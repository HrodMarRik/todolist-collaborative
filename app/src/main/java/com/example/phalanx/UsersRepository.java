package com.example.phalanx;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.*;

public class UsersRepository implements IUsersRepository{

    private static UsersRepository instance;
    static String baseUrl = "https://localhost:8080/api";
    Users result;

    public static UsersRepository getInstance(){
        if(instance==null){
            instance= new UsersRepository();
        }
        return instance;
    }
    @Override
    public boolean remove(Users users) {
        return false;
    }

    @Override
    public boolean isExist(Users users) {
        return false;
    }

    @Override
    public Users getUser(int id) throws IOException{
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
                        result = new Gson().fromJson(response.body().string(), Users.class);
                    }
                });

            return result!=null ? result : new Users("", "", "","","","", new ArrayList<ListInfo>(),
                    new ArrayList<ListRoles>(), new ArrayList<ListComment>(), new ArrayList<Task>());
    }
}
