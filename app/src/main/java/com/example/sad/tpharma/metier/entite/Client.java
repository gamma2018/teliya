package com.example.sad.tpharma.metier.entite;

public class Client
{
    private String nomMutuelle;
    private String nomClient;
    private String prenomClient;
    private String telClient;

    public Client(String nomMutuelle, String nomClient, String prenomClient, String telClient) {
        this.nomMutuelle = nomMutuelle;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.telClient = telClient;
    }

    public String getNomMutuelle() {
        return nomMutuelle;
    }

    public void setNomMutuelle(String nomMutuelle) {
        this.nomMutuelle = nomMutuelle;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }
}
