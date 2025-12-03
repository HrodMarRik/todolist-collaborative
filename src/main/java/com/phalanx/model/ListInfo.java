package com.phalanx.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class ListInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_list;

    String title;
    String listtype;
    String listscope;

    @OneToMany(mappedBy = "ListInfo")
    @JsonIgnoreProperties("ListInfo")
    List<ListColumn> ListColumn;

    @ManyToMany(mappedBy = "listgroup")
    @JsonIgnoreProperties("listgroup")
    Set<Users> members;

    @ManyToMany
    @JoinTable(
    name = "assigned_lists", 
    joinColumns = @JoinColumn(name = "id_list"), 
    inverseJoinColumns = @JoinColumn(name = "id_roles"))
    @JsonIgnoreProperties("assignedLists")
    Set<ListRoles> listRoles;

    public ListInfo(){}

    public ListInfo(String title, String listtype, String listscope, List<ListColumn> ListColumn, Set<Users> members, Set<ListRoles> listRoles) {
        this.title = title;
        this.listtype = listtype;
        this.listscope = listscope;
        this.ListColumn = ListColumn;
        this.members = members;
        this.listRoles = listRoles;
    }

    public int getId_list() {
        return this.id_list;
    }

    public void setId_list(int id_list) {
        this.id_list = id_list;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListtype() {
        return this.listtype;
    }

    public void setListtype(String listtype) {
        this.listtype = listtype;
    }

    public String getListscope() {
        return this.listscope;
    }

    public void setListscope(String listscope) {
        this.listscope = listscope;
    }

    public List<ListColumn> getListColumn() {
        return this.ListColumn;
    }

    public void setListColumn(List<ListColumn> ListColumn) {
        this.ListColumn = ListColumn;
    }

    public Set<Users> getMembers() {
        return this.members;
    }

    public void setMembers(Set<Users> members) {
        this.members = members;
    }

    public Set<ListRoles> getListRoles() {
        return this.listRoles;
    }

    public void setListRoles(Set<ListRoles> listRoles) {
        this.listRoles = listRoles;
    }

}
