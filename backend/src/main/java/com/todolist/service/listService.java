package com.todolist.service;

import com.todolist.object.listInfo;

public class listService {

    public static listInfo[] getAllList (){
        listInfo[] listInfo = {new listInfo("To-do-Test", "Table", "Profesional"),
                        new listInfo("To-do-Test02", "Table", "Profesional"),
                        new listInfo("To-do-Test03", "Checklist", "Personnal")};
        return listInfo;
    }

    public static listInfo getListInfo (String id){
        var listInfo = new listInfo("To-do-Test", "Table", "Profesional");
        return listInfo;
    }
}