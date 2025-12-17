package com.example.phalanx;

import java.util.ArrayList;

public interface IUsersRepository {

    boolean remove(Users users);

    boolean isExist(Users users);

    ArrayList<Users> getAll();
}
