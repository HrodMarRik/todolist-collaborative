package com.example.phalanx;

import org.json.JSONObject;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class TasksRepository {

    private static TasksRepository instance;
    static String baseUrl = "http://10.0.2.2:8080/api";

    public static TasksRepository getInstance(){
        if(instance==null){
            instance= new TasksRepository();
        }
        return instance;
    }

    public interface Callback {
        void onResult(boolean success);
    }

    public void postTask(String nom, String description, Date dateFin, Date dateCreation, String status, String priorite,
                         Integer idColumn, Integer idUsers, TasksRepository.Callback callback) {
        new Thread(() -> {
            try {
                URL url = new URL(baseUrl + "/task");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                JSONObject json = new JSONObject();
                json.put("nom", nom);
                json.put("description", description);
                json.put("dateFin", dateFin);
                json.put("daeteCreation", dateCreation);
                json.put("status", status);
                json.put("priorite", priorite);
                json.put("idColumn", idColumn);
                json.put("idUsers", idUsers);

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

}
