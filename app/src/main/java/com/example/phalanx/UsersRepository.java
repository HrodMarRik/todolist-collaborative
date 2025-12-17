package com.example.phalanx;

import java.util.ArrayList;

public class UsersRepository implements IUsersRepository{

    private static UsersRepository instance;
    static String baseUrl = "http://localhost:8080/api";

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
    public ArrayList<Users> getAll() {
        return null;
    }
}
