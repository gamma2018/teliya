package com.example.sad.tpharma.entite;

public class InventaireItem {

    private String libelle, codeProd, date;
    private int montant;
    private int quantite;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCodeProd() {
        return codeProd;
    }

    public void setCodeProd(String codeProd) {
        this.codeProd = codeProd;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public InventaireItem(String libelle, String codeProd, String date, int montant) {
        this.libelle = libelle;
        this.codeProd = codeProd;
        this.date = date;
        this.montant = montant;
    }

    public InventaireItem() {
    }
}
