package com.phalanx.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class ListRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_roles;

    String name;

    @ManyToMany(mappedBy = "listRoles")
    @JsonIgnoreProperties("listRoles")
    Set<Users> assignedUsers;

    @ManyToMany(mappedBy = "listRoles")
    @JsonIgnoreProperties("listRoles")
    Set<ListInfo> assignedLists;

    public ListRoles(){}

    public ListRoles(String name, Set<Users> assignedUsers, Set<ListInfo> assignedLists) {
        this.name = name;
        this.assignedUsers = assignedUsers;
        this.assignedLists = assignedLists;
    }

    public int getId_roles() {
        return this.id_roles;
    }

    public void setId_roles(int id_roles) {
        this.id_roles = id_roles;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Users> getAssignedUsers() {
        return this.assignedUsers;
    }

    public void setAssignedUsers(Set<Users> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    public Set<ListInfo> getAssignedLists() {
        return this.assignedLists;
    }

    public void setAssignedLists(Set<ListInfo> assignedLists) {
        this.assignedLists = assignedLists;
    }

}