package com.example.phalanx;

import java.util.ArrayList;

public class ListColumn {

    String title;
    ArrayList<Task> tasks;
    Integer id_column;

    public ListColumn(){}

    public ListColumn(String titre, ArrayList<Task> tasks, Integer id) {
        this.title = titre;
        this.tasks = tasks;
        this.id_column = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public Integer getId_column() {
        return id_column;
    }

    public void setId_column(Integer id_column) {
        this.id_column = id_column;
    }
}
