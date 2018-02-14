package com.example.sad.tpharma.metier.entite;

public class Produit {
    private String libelle;
    private int prixUnitaire;
    private int quantite;
    private String peremption;
    private String type;
    private String code;


    public Produit()
    {}

    public Produit(String libelle,  String type, int prixUnitaire, int quantite, String peremption) {

        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.type = type;
        this.peremption = peremption;

    }

    public Produit(String libelle, int prixUnitaire, int quantite, String peremption, String type, String code) {
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.peremption = peremption;
        this.type = type;
        this.code = code;
    }

    public Produit(String libelle, int prixUnitaire, int quantite, String peremption, String code) {
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.peremption = peremption;
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(int prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeremption() {
        return peremption;
    }

    public void setPeremption(String peremption) {
        this.peremption = peremption;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
