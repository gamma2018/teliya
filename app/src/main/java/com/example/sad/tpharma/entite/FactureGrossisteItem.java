package com.example.sad.tpharma.entite;

public class FactureGrossisteItem {

    private String numeroFacture;
    private String dateFacture;
    private int montant;
    private String grossiste;

    public FactureGrossisteItem() {
    }

    public FactureGrossisteItem(String numeroFacture, String dateFacture, int montant, String grossiste) {
        this.numeroFacture = numeroFacture;
        this.dateFacture = dateFacture;
        this.montant = montant;
        this.grossiste = grossiste;
    }

    public String getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(String numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public String getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(String dateFacture) {
        this.dateFacture = dateFacture;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getGrossiste() {
        return grossiste;
    }

    public void setGrossiste(String grossiste) {
        this.grossiste = grossiste;
    }
}
