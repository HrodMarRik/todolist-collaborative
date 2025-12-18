package com.example.phalanx;

import java.util.ArrayList;

public class ListInfo {
    private String title;
    private String listscope;
    private String listtype;
    private ArrayList<ListColumn> ListColumn;
    Integer id_list;

    public ListInfo(){}

    public ListInfo(String title, String listscope, String listtype, ArrayList<ListColumn> ListColumn, Integer id) {
        this.title = title;
        this.listscope = listscope;
        this.listtype = listtype;
        this.ListColumn = ListColumn;
        this.id_list = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListscope() {
        return listscope;
    }

    public void setListscope(String listscope) {
        this.listscope = listscope;
    }

    public String getListtype() {
        return listtype;
    }

    public void setListtype(String listtype) {
        this.listtype = listtype;
    }

    public ArrayList<ListColumn> getListColumns() {
        return ListColumn;
    }

    public void setListColumns(ArrayList<ListColumn> listColumn) {
        this.ListColumn = listColumn;
    }

    public Integer getId_list() {
        return id_list;
    }

    public void setId_list(Integer id_list) {
        this.id_list = id_list;
    }
}
