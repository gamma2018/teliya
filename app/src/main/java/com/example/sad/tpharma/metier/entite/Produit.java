package com.example.sad.tpharma.metier.entite;

public class Produit {

    private String libelleProduit;
    private String type;
    private String nomForme;
    private String code;
    private int suil;
    private int pu;
    private String date;


    public Produit(String libelleProduit, String type, String nomForme, String code, int suil) {
        this.libelleProduit = libelleProduit;
        this.type = type;
        this.nomForme = nomForme;
        this.code = code;
        this.suil = suil;
    }

    public Produit(String libelleProduit, String type, String nomForme, String code, int suil, int pu, String date) {
        this.libelleProduit = libelleProduit;
        this.type = type;
        this.nomForme = nomForme;
        this.code = code;
        this.suil = suil;
        this.pu = pu;
        this.date = date;
    }

    public int getSuil() {
        return suil;
    }

    public void setSuil(int suil) {
        this.suil = suil;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Produit(){}

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNomForme() {
        return nomForme;
    }

    public void setNomForme(String nomForme) {
        this.nomForme = nomForme;
    }

    public int getPu() {
        return pu;
    }

    public void setPu(int pu) {
        this.pu = pu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
