package models;

import java.io.Serializable;

public class Agence implements Serializable {
    private String nom;
    private String departement;
    private String sousDepartement;
    private String numEntreprise;
    private String contac1;
    private String contact2;
    private String adresse;
    private String telephone1;
    private String telephone2;
    private String email1;
    private String email2;
    private String mdp;
    private String lien;

    public Agence(){}

    public Agence(String nom, String departement, String sousDepartement, String numEntreprise,String adresse, String lien) {
        this.nom = nom;
        this.departement = departement;
        this.sousDepartement = sousDepartement;
        this.numEntreprise = numEntreprise;
        this.lien = lien;
        this.adresse = adresse;
    }

    public Agence(String nom, String departement, String sousDepartement, String numEntreprise, String contac1, String contact2, String adresse, String telephone1, String telephone2, String email1, String email2, String mdp, String lien) {
        this.nom = nom;
        this.departement = departement;
        this.sousDepartement = sousDepartement;
        this.numEntreprise = numEntreprise;
        this.contac1 = contac1;
        this.contact2 = contact2;
        this.adresse = adresse;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.email1 = email1;
        this.email2 = email2;
        this.mdp = mdp;
        this.lien = lien;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getSousDepartement() {
        return sousDepartement;
    }

    public void setSousDepartement(String sousDepartement) {
        this.sousDepartement = sousDepartement;
    }

    public String getNumEntreprise() {
        return numEntreprise;
    }

    public void setNumEntreprise(String numEntreprise) {
        this.numEntreprise = numEntreprise;
    }

    public String getContac1() {
        return contac1;
    }

    public void setContac1(String contac1) {
        this.contac1 = contac1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
}
