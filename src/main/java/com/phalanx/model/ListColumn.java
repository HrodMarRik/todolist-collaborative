package com.phalanx.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ListColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_column;

    String title;

    @ManyToOne
    @JoinColumn(name="id_list")
    @JsonIgnoreProperties("ListColumn")
    ListInfo ListInfo;

    @OneToMany(mappedBy = "ListColumn")
    @JsonIgnoreProperties("ListColumn")
    List<Task> Tasks;

    public ListColumn() {
    }

    public ListColumn(String title, ListInfo ListInfo, List<Task> Tasks) {
        this.title = title;
        this.ListInfo = ListInfo;
        this.Tasks = Tasks;
    }

    public int getId_column() {
        return this.id_column;
    }

    public void setId_column(int id_column) {
        this.id_column = id_column;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ListInfo getListInfo() {
        return this.ListInfo;
    }

    public void setListInfo(ListInfo ListInfo) {
        this.ListInfo = ListInfo;
    }

    public List<Task> getTasks() {
        return this.Tasks;
    }

    public void setTasks(List<Task> Tasks) {
        this.Tasks = Tasks;
    }


}
