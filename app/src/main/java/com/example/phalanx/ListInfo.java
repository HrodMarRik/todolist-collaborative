package com.example.phalanx;

public class ListInfo {
    private String titre;
    private String listScope;
    private String listType;

    public ListInfo(){}

    public ListInfo(String titre, String listScope, String listType) {
        this.titre = titre;
        this.listScope = listScope;
        this.listType = listType;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getListScope() {
        return listScope;
    }

    public void setListScope(String listScope) {
        this.listScope = listScope;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }
}
