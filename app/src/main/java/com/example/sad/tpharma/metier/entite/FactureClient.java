package com.example.sad.tpharma.metier.entite;

public class FactureClient {
    private String numeroFactureclient;
    private int montantFactureClient;
    private String resteFactureClient;
    private  String statutFactureClient;
    private String dateFactureClient;

    public FactureClient(String numeroFactureclient, int montantFactureClient, String resteFactureClient, String statutFactureClient, String dateFactureClient) {
        this.numeroFactureclient = numeroFactureclient;
        this.montantFactureClient = montantFactureClient;
        this.resteFactureClient = resteFactureClient;
        this.statutFactureClient = statutFactureClient;
        this.dateFactureClient = dateFactureClient;
    }

    public String getNumeroFactureclient() {
        return numeroFactureclient;
    }

    public void setNumeroFactureclient(String numeroFactureclient) {
        this.numeroFactureclient = numeroFactureclient;
    }

    public int getMontantFactureClient() {
        return montantFactureClient;
    }

    public void setMontantFactureClient(int montantFactureClient) {
        this.montantFactureClient = montantFactureClient;
    }

    public String getResteFactureClient() {
        return resteFactureClient;
    }

    public void setResteFactureClient(String resteFactureClient) {
        this.resteFactureClient = resteFactureClient;
    }

    public String getStatutFactureClient() {
        return statutFactureClient;
    }

    public void setStatutFactureClient(String statutFactureClient) {
        this.statutFactureClient = statutFactureClient;
    }

    public String getDateFactureClient() {
        return dateFactureClient;
    }

    public void setDateFactureClient(String dateFactureClient) {
        this.dateFactureClient = dateFactureClient;
    }
}
