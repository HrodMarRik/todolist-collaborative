package com.example.phalanx;

import java.util.ArrayList;

public class Users {
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String role;
    private String avatar;
    private ArrayList<ListInfo> listgroup;
    private ArrayList<ListRoles> listRoles;
    private ArrayList<ListComment> listComments;
    private ArrayList<Task> tasks;

    public Users(){}

    public Users(String lastname, String firstname, String email, String password, String role, String avatar,
                 ArrayList<ListInfo> listgroup, ArrayList<ListRoles> listRoles, ArrayList<ListComment> listComments,
                 ArrayList<Task> tasks) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
        this.listgroup = listgroup;
        this.listRoles = listRoles;
        this.listComments = listComments;
        this.tasks = tasks;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ArrayList<ListInfo> getListgroup() {
        return listgroup;
    }

    public void setListgroup(ArrayList<ListInfo> listgroup) {
        this.listgroup = listgroup;
    }

    public ArrayList<ListRoles> getListRoles() {
        return listRoles;
    }

    public void setListRoles(ArrayList<ListRoles> listRoles) {
        this.listRoles = listRoles;
    }

    public ArrayList<ListComment> getListComments() {
        return listComments;
    }

    public void setListComments(ArrayList<ListComment> listComments) {
        this.listComments = listComments;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
