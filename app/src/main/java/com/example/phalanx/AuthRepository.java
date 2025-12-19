package com.example.phalanx;

import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthRepository {

    public interface Callback {
        void onResult(boolean success);
    }

    public void login(String email, String password, Callback callback) {
        new Thread(() -> {
            try {
                URL url = new URL("http://10.0.2.2:8080/api/auth/login");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                JSONObject json = new JSONObject();
                json.put("email", email);
                json.put("password", password);

                OutputStream os = conn.getOutputStream();
                os.write(json.toString().getBytes());
                os.flush();
                os.close();

                int code = conn.getResponseCode();
                callback.onResult(code == 200);

                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
                callback.onResult(false);
            }
        }).start();
    }

    public void register(String firstName, String lastName, String email, String password, Callback callback) {

        new Thread(() -> {
            try {
                URL url = new URL("http://10.0.2.2:8080/api/auth/register");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                JSONObject json = new JSONObject();
                json.put("firstName", firstName);
                json.put("lastName", lastName);
                json.put("email", email);
                json.put("password", password);
                json.put("role", "user");
                json.put("avatar", "");

                OutputStream os = conn.getOutputStream();
                os.write(json.toString().getBytes());
                os.flush();
                os.close();

                int code = conn.getResponseCode();
                callback.onResult(code == 201 || code == 200);

                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
                callback.onResult(false);
            }
        }).start();
    }
}