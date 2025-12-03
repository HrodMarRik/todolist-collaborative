package com.phalanx.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_task;

    String name;
    String description;
    LocalDate enddate;
    LocalDate creationdate;
    String status;
    String priority;

    @ManyToOne
    @JoinColumn(name="id_column")
    @JsonIgnoreProperties("Tasks")
    ListColumn ListColumn;

    @ManyToOne
    @JoinColumn(name="id_users")
    @JsonIgnoreProperties("task")
    Users Users;

    @OneToMany(mappedBy = "task")
    @JsonIgnoreProperties("task")
    Set<ListComment> listComments;

    public Task() {
    }

    public Task(String name, String description, LocalDate enddate, LocalDate creationdate, String status, String priority, ListColumn ListColumn, Users Users, Set<ListComment> listComments) {
        this.name = name;
        this.description = description;
        this.enddate = enddate;
        this.creationdate = creationdate;
        this.status = status;
        this.priority = priority;
        this.ListColumn = ListColumn;
        this.Users = Users;
        this.listComments = listComments;
    }

    public int getId_task() {
        return this.id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEnddate() {
        return this.enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public LocalDate getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(LocalDate creationdate) {
        this.creationdate = creationdate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public ListColumn getListColumn() {
        return this.ListColumn;
    }

    public void setListColumn(ListColumn ListColumn) {
        this.ListColumn = ListColumn;
    }

    public Users getUsers() {
        return this.Users;
    }

    public void setUsers(Users Users) {
        this.Users = Users;
    }

    public Set<ListComment> getListComments() {
        return this.listComments;
    }

    public void setListComments(Set<ListComment> listComments) {
        this.listComments = listComments;
    }

}