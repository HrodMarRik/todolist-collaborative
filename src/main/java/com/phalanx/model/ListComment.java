package com.phalanx.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ListComment {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comment;

    String content;

    @ManyToOne
    @JoinColumn(name="id_task")
    @JsonIgnoreProperties("listComments")
    Task task;

    @ManyToOne
    @JoinColumn(name="id_users")
    @JsonIgnoreProperties("listComments")
    Users user;

    public ListComment() {
    }

    public ListComment(String content, Task task, Users user) {
        this.content = content;
        this.task = task;
        this.user = user;
    }

    public int getId_comment() {
        return this.id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Users getUser() {
        return this.user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
