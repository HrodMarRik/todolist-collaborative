package com.phalanx.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_users;

    String lastname;
    String firstname;
    String email;
    String password;
    String role;
    String avatar;

    @ManyToMany
    @JoinTable(
    name = "owner", 
    joinColumns = @JoinColumn(name = "id_users"), 
    inverseJoinColumns = @JoinColumn(name = "id_list"))
    @JsonIgnoreProperties("members")
    Set<ListInfo> listgroup;

    @ManyToMany
    @JoinTable(
    name = "assigned_users", 
    joinColumns = @JoinColumn(name = "id_users"), 
    inverseJoinColumns = @JoinColumn(name = "id_roles"))
    @JsonIgnoreProperties("assignedUsers")
    Set<ListRoles> listRoles;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    Set<ListComment> listComments;

    @OneToMany(mappedBy = "Users")
    @JsonIgnoreProperties("Users")
    Set<Task> task;

    public Users(){}

    public Users(String lastname, String firstname, String email, String password, String role, String avatar, Set<ListInfo> listgroup, Set<ListRoles> listRoles, Set<ListComment> listComments, Set<Task> task) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
        this.listgroup = listgroup;
        this.listRoles = listRoles;
        this.listComments = listComments;
        this.task = task;
    }

    public int getId_users() {
        return this.id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<ListInfo> getListgroup() {
        return this.listgroup;
    }

    public void setListgroup(Set<ListInfo> listgroup) {
        this.listgroup = listgroup;
    }

    public Set<ListRoles> getListRoles() {
        return this.listRoles;
    }

    public void setListRoles(Set<ListRoles> listRoles) {
        this.listRoles = listRoles;
    }

    public Set<ListComment> getListComments() {
        return this.listComments;
    }

    public void setListComments(Set<ListComment> listComments) {
        this.listComments = listComments;
    }

    public Set<Task> getTask() {
        return this.task;
    }

    public void setTask(Set<Task> task) {
        this.task = task;
    }

}