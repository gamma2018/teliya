package com.example.sad.tpharma.metier.entite;

public class Mutuelle {
    private int idMutuelle;
    private String nomMutuelle;
    private String phoneMutuelle;
    private String adresseMutuelle;
    private String emailMutuelle;

    public Mutuelle() {
    }

    public Mutuelle(int idMutuelle, String nomMutuelle, String phoneMutuelle, String adresseMutuelle, String emailMutuelle) {
        this.idMutuelle = idMutuelle;
        this.nomMutuelle = nomMutuelle;
        this.phoneMutuelle = phoneMutuelle;
        this.adresseMutuelle = adresseMutuelle;
        this.emailMutuelle = emailMutuelle;
    }

    public Mutuelle(String nomMutuelle, String phoneMutuelle, String adresseMutuelle, String emailMutuelle) {
        this.nomMutuelle = nomMutuelle;
        this.phoneMutuelle = phoneMutuelle;
        this.adresseMutuelle = adresseMutuelle;
        this.emailMutuelle = emailMutuelle;
    }

    public String getNomMutuelle() {
        return nomMutuelle;
    }

    public void setNomMutuelle(String nomMutuelle) {
        this.nomMutuelle = nomMutuelle;
    }

    public String getPhoneMutuelle() {
        return phoneMutuelle;
    }

    public void setPhoneMutuelle(String phoneMutuelle) {
        this.phoneMutuelle = phoneMutuelle;
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
}
