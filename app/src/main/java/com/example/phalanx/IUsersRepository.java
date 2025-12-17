package com.example.phalanx;

import java.io.IOException;
import java.util.ArrayList;

public interface IUsersRepository {

    boolean remove(Users users);

    boolean isExist(Users users);

    Users getUser(int id) throws IOException;
}
