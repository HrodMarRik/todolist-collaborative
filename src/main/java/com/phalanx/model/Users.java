package com.phalanx.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    public Users(){}

    public Users(String lastName, String firstName, String email, String password, String role, String avatar) {
        this.lastname = lastName;
        this.firstname = firstName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
    }

    public int getId_list() {
        return this.id_users;
    }

    public void setId_list(int id_list) {
        this.id_users = id_list;
    }

    public String getLastName() {
        return this.lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getFirstName() {
        return this.firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
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

}