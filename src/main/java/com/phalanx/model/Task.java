package com.phalanx.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    int id_column;
    int id_users;

    public Task() {
    }

    public Task( String name, String description, LocalDate enddate, LocalDate creationdate, String status, String priority, int id_column, int id_users) {
        this.name = name;
        this.description = description;
        this.enddate = enddate;
        this.creationdate = creationdate;
        this.status = status;
        this.priority = priority;
        this.id_column = id_column;
        this.id_users = id_users;
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

    public int getId_column() {
        return this.id_column;
    }

    public void setId_column(int id_column) {
        this.id_column = id_column;
    }

    public int getId_users() {
        return this.id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }    

}