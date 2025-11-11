package com.todolist.object;

public class listInfo {

    String title;
    String listType;
    String listScope;

    public listInfo(String title, String listType, String listScope) {
        this.title = title;
        this.listType = listType;
        this.listScope = listScope;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListType() {
        return this.listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getListScope() {
        return this.listScope;
    }

    public void setListScope(String listScope) {
        this.listScope = listScope;
    }

}

