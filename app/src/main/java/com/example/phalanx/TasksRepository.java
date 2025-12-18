package com.example.phalanx;

import org.json.JSONObject;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TasksRepository {

    private static TasksRepository instance;
    static String baseUrl = "http://10.0.2.2:8080/api";

    public static TasksRepository getInstance(){
        if(instance==null){
            instance= new TasksRepository();
        }
        return instance;
    }

    public void postTasks(RequestBody body) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(baseUrl + "/task")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(final Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {

                    }
                });
    }
}
