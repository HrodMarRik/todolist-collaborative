package com.phalanx.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ListComment {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comment;

    String content;
    int id_task;
    int id_users;

    public ListComment() {
    }

    public ListComment(String content, int id_task, int id_users) {
        this.content = content;
        this.id_task = id_task;
        this.id_users = id_users;
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

    public int getId_task() {
        return this.id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public int getId_users() {
        return this.id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

}
