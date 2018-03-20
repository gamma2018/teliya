package com.example.sad.tpharma.metier.entite;

public class FactureGrossiste {
    private int factureGrossisteId;
    private int commandeId;
    private String numeroFactureGrossiste;
    private int montantFactureGrossiste;
    private int resteFactureGrossiste;
    private String statusFactureGrossiste;
    private String dateFactureGrossiste;
    private String grossiste;

    public FactureGrossiste(int factureGrossisteId, int commandeId, String numeroFactureGrossiste, int montantFactureGrossiste, int resteFactureGrossiste, String statusFactureGrossiste) {
        this.factureGrossisteId = factureGrossisteId;
        this.commandeId = commandeId;
        this.numeroFactureGrossiste = numeroFactureGrossiste;
        this.montantFactureGrossiste = montantFactureGrossiste;
        this.resteFactureGrossiste = resteFactureGrossiste;
        this.statusFactureGrossiste = statusFactureGrossiste;
    }

    public FactureGrossiste(String numeroFactureGrossiste, int montantFactureGrossiste, String dateFactureGrossiste, String grossiste) {
        this.numeroFactureGrossiste = numeroFactureGrossiste;
        this.montantFactureGrossiste = montantFactureGrossiste;
        this.dateFactureGrossiste = dateFactureGrossiste;
        this.grossiste = grossiste;
    }

    public String getDateFactureGrossiste() {
        return dateFactureGrossiste;
    }

    public void setDateFactureGrossiste(String dateFactureGrossiste) {
        this.dateFactureGrossiste = dateFactureGrossiste;
    }

    public String getGrossiste() {
        return grossiste;
    }

    public void setGrossiste(String grossiste) {
        this.grossiste = grossiste;
    }

    public int getFactureGrossisteId() {
        return factureGrossisteId;
    }

    public void setFactureGrossisteId(int factureGrossisteId) {
        this.factureGrossisteId = factureGrossisteId;
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    public String getNumeroFactureGrossiste() {
        return numeroFactureGrossiste;
    }

    public void setNumeroFactureGrossiste(String numeroFactureGrossiste) {
        this.numeroFactureGrossiste = numeroFactureGrossiste;
    }

    public int getMontantFactureGrossiste() {
        return montantFactureGrossiste;
    }

    public void setMontantFactureGrossiste(int montantFactureGrossiste) {
        this.montantFactureGrossiste = montantFactureGrossiste;
    }

    public int getResteFactureGrossiste() {
        return resteFactureGrossiste;
    }

    public void setResteFactureGrossiste(int resteFactureGrossiste) {
        this.resteFactureGrossiste = resteFactureGrossiste;
    }

    public String getStatusFactureGrossiste() {
        return statusFactureGrossiste;
    }

    public void setStatusFactureGrossiste(String statusFactureGrossiste) {
        this.statusFactureGrossiste = statusFactureGrossiste;
    }
}
