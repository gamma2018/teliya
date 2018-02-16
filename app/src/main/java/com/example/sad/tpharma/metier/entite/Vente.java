package com.example.sad.tpharma.metier.entite;

public class Vente {
    private String nomClient;
    private String factureClientId;

    public Vente(String nomClient, String factureClientId) {
        this.nomClient = nomClient;
        this.factureClientId = factureClientId;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getFactureClientId() {
        return factureClientId;
    }

    public void setFactureClientId(String factureClientId) {
        this.factureClientId = factureClientId;
    }
}
