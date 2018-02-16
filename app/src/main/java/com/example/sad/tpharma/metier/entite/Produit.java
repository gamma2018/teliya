package com.example.sad.tpharma.metier.entite;

public class Produit {

    private String libelleType;
    private String designation;
    private String nomForme;
    private String code;
    private String datePremption;
    private int quantiteInitial;
    private int pu;

    public Produit(String libelleType, String designation, String nomForme, String code, String datePremption, int quantiteInitial, int pu) {
        this.libelleType = libelleType;
        this.designation = designation;
        this.nomForme = nomForme;
        this.code = code;
        this.datePremption = datePremption;
        this.quantiteInitial = quantiteInitial;
        this.pu = pu;
    }

    public Produit(String designation, int pu, int quantiteInitial, String datePremption, String code) {
        this.designation = designation;
        this.pu = pu;
        this.quantiteInitial = quantiteInitial;
        this.datePremption = datePremption;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDatePremption() {
        return datePremption;
    }

    public void setDatePremption(String datePremption) {
        this.datePremption = datePremption;
    }

    public int getPu() {
        return pu;
    }

    public void setPu(int pu) {
        this.pu = pu;
    }

    public Produit(String libelleType, String designation, String nomForme, int quantiteInitial) {
        this.libelleType = libelleType;
        this.designation = designation;
        this.nomForme = nomForme;
        this.quantiteInitial = quantiteInitial;
    }
    public Produit(){}

    public String getLibelleType() {
        return libelleType;
    }

    public void setLibelleType(String libelleType) {
        this.libelleType = libelleType;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNomForme() {
        return nomForme;
    }

    public void setNomForme(String nomForme) {
        this.nomForme = nomForme;
    }

    public int getQuantiteInitial() {
        return quantiteInitial;
    }

    public void setQuantiteInitial(int quantiteInitial) {
        this.quantiteInitial = quantiteInitial;
    }
}
