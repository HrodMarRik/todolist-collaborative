package com.phalanx.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ListInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_list;

    String title;
    String listtype;
    String listscope;

    public ListInfo(){}

    public ListInfo(String title, String listType, String listScope) {
        this.title = title;
        this.listtype = listType;
        this.listscope = listScope;
    }


    public int getId() {
        return this.id_list;
    }

    public void setId(int id) {
        this.id_list = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListType() {
        return this.listtype;
    }

    public void setListType(String listType) {
        this.listtype = listType;
    }

    public String getListScope() {
        return this.listscope;
    }

    public void setListScope(String listScope) {
        this.listscope = listScope;
    }

}
