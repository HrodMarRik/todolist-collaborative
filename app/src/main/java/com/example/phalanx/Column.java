package com.example.phalanx;

import java.util.ArrayList;

public class Column {

    String titre;
    ArrayList<Task> tasks;

    public Column(String titre, ArrayList<Task> tasks) {
        this.titre = titre;
        this.tasks = tasks;
    }
}
