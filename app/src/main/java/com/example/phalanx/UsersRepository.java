package com.example.phalanx;

import android.content.SharedPreferences;
import java.io.IOException;

import okhttp3.*;

public class UsersRepository{

    private static UsersRepository instance;
    static String baseUrl = "http://10.0.2.2:8080/api";

    public static UsersRepository getInstance(){
        if(instance==null){
            instance= new UsersRepository();
        }
        return instance;
    }

    public void getUser(int id, SharedPreferences result) throws IOException{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                    .url(baseUrl + "/user/" + id)
                    .build();

        client.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(final Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        if(response.isSuccessful()) {
                            String res = response.body().string();
                            SharedPreferences.Editor editor = result.edit();
                            editor.putString("user", res);
                            editor.apply();
                        }
                    }
                });
    }
}
