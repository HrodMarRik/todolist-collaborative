package com.phalanx.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ListColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_column;

    String title;
    int id_list;

    public ListColumn() {
    }

    public ListColumn( String title, int id_list) {
        this.title = title;
        this.id_list = id_list;
    }

    public int getId_column() {
        return this.id_column;
    }

    public void setId_column(int id_column) {
        this.id_column = id_column;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId_list() {
        return this.id_list;
    }

    public void setId_list(int id_list) {
        this.id_list = id_list;
    }

}
