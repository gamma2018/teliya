package com.example.sad.tpharma.metier.entite;

public class FactureCommande {
    private int factureCommandId;
    private int commandeId;
    private String numeroFactureCommande;
    private int montantFactureCommande;
    private int resteFactureCommande;
    private String statusFactureCommande;

    public FactureCommande(int factureCommandId, int commandeId, String numeroFactureCommande, int montantFactureCommande, int resteFactureCommande, String statusFactureCommande) {
        this.factureCommandId = factureCommandId;
        this.commandeId = commandeId;
        this.numeroFactureCommande = numeroFactureCommande;
        this.montantFactureCommande = montantFactureCommande;
        this.resteFactureCommande = resteFactureCommande;
        this.statusFactureCommande = statusFactureCommande;
    }

    public int getFactureCommandId() {
        return factureCommandId;
    }

    public void setFactureCommandId(int factureCommandId) {
        this.factureCommandId = factureCommandId;
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    public String getNumeroFactureCommande() {
        return numeroFactureCommande;
    }

    public void setNumeroFactureCommande(String numeroFactureCommande) {
        this.numeroFactureCommande = numeroFactureCommande;
    }

    public int getMontantFactureCommande() {
        return montantFactureCommande;
    }

    public void setMontantFactureCommande(int montantFactureCommande) {
        this.montantFactureCommande = montantFactureCommande;
    }

    public int getResteFactureCommande() {
        return resteFactureCommande;
    }

    public void setResteFactureCommande(int resteFactureCommande) {
        this.resteFactureCommande = resteFactureCommande;
    }

    public String getStatusFactureCommande() {
        return statusFactureCommande;
    }

    public void setStatusFactureCommande(String statusFactureCommande) {
        this.statusFactureCommande = statusFactureCommande;
    }
}
