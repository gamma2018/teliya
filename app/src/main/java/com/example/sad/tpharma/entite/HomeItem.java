package com.example.sad.tpharma.entite;

public class HomeItem {

    private int image;
    private String libelle;
    private String description;
    private String username;
    private int idGrossiste;

    private int idclient;
    private String nomClient;
    private String prenomClient;
    private String nomClientMutuelle;
    private String telephoneClient;

    private String nomMutuelle, telephoneMutuelle, adresseMutuelle, emailMutuelle;
    private int idMutuelle;

    public HomeItem(int image, String libelle, String description, String username) {
        this.image = image;
        this.libelle = libelle;
        this.description = description;
        this.username = username;
    }

    public HomeItem(int image, String libelle, String description, String username, int idGrossiste) {
        this.image = image;
        this.libelle = libelle;
        this.description = description;
        this.username = username;
        this.idGrossiste = idGrossiste;
    }

    public HomeItem(int image, int idclient,String nomClient, String prenomClient, String telephoneClient,String nomClientMutuelle) {
        this.image = image;
        this.idclient = idclient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.telephoneClient = telephoneClient;
        this.nomClientMutuelle = nomClientMutuelle;
    }

    public HomeItem(int image, String nomMutuelle, String telephoneMutuelle, String emailMutuelle, String adresseMutuelle) {
        this.image = image;
        this.nomMutuelle = nomMutuelle;
        this.telephoneMutuelle = telephoneMutuelle;
        this.emailMutuelle = emailMutuelle;
        this.adresseMutuelle = adresseMutuelle;
    }

    public HomeItem() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdGrossiste() {
        return idGrossiste;
    }

    public void setIdGrossiste(int idGrossiste) {
        this.idGrossiste = idGrossiste;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
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

    public String getNomClientMutuelle() {
        return nomClientMutuelle;
    }

    public void setNomClientMutuelle(String nomClientMutuelle) {
        this.nomClientMutuelle = nomClientMutuelle;
    }

    public String getTelephoneClient() {
        return telephoneClient;
    }

    public void setTelephoneClient(String telephoneClient) {
        this.telephoneClient = telephoneClient;
    }

    public String getNomMutuelle() {
        return nomMutuelle;
    }

    public void setNomMutuelle(String nomMutuelle) {
        this.nomMutuelle = nomMutuelle;
    }

    public String getTelephoneMutuelle() {
        return telephoneMutuelle;
    }

    public void setTelephoneMutuelle(String telephoneMutuelle) {
        this.telephoneMutuelle = telephoneMutuelle;
    }

    public String getAdresseMutuelle() {
        return adresseMutuelle;
    }

    public void setAdresseMutuelle(String adresseMutuelle) {
        this.adresseMutuelle = adresseMutuelle;
    }

    public String getEmailMutuelle() {
        return emailMutuelle;
    }

    public void setEmailMutuelle(String emailMutuelle) {
        this.emailMutuelle = emailMutuelle;
    }

    public int getIdMutuelle() {
        return idMutuelle;
    }

    public void setIdMutuelle(int idMutuelle) {
        this.idMutuelle = idMutuelle;
    }
}
