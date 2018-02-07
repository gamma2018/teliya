package com.example.sad.tpharma.entite;

public class HistoriqueItem {

    private String libelle, codeProd, date;
    private int montant;

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
}
