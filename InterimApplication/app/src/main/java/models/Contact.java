package models;

import java.io.Serializable;

public class Contact implements Serializable {
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresseMail;
    private String mdp;

    public Contact(){}
    public Contact(String nom, String prenom, String telephone, String adresseMail, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresseMail = adresseMail;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
