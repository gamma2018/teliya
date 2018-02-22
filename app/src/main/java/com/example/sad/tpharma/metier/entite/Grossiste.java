package com.example.sad.tpharma.metier.entite;

public class Grossiste {

    private int code;
    private String libelle;
    private String adresse;
    private String telephone;


    public Grossiste() {
    }

    public Grossiste(String libelle,  String telephone, String adresse) {
        this.libelle = libelle;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public Grossiste(int code, String libelle,  String telephone, String adresse) {
        this.code = code;
        this.libelle = libelle;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
