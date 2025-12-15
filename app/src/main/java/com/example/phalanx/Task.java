package com.example.phalanx;

import java.util.Date;

public class Task {
    private String nom;
    private String description;
    private Date dateFin;
    private Date dateCreation;
    private String status;
    private String priorite;

    public Task() {}

    public Task(String nom, String description, Date dateFin, Date dateCreation, String status, String priorite) {
        this.nom = nom;
        this.description = description;
        this.dateFin = dateFin;
        this.dateCreation = dateCreation;
        this.status = status;
        this.priorite = priorite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }
}
