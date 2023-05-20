package models;

import java.util.ArrayList;

public class Publisher {
    private int id;
    private String departement;
    private String sousDepartement;
    private String numEntreprise;
    private String adresse;
    private String lien;
    private String email1;
    private String telephone1;
    private String mdp;
    private Contact contac1;
    private Contact contact2;

    public Publisher() {}

    public Publisher(String departement, String sousDepartement, String numEntreprise, String adresse, String lien, Contact contac1, Contact contact2) {
        this.departement = departement;
        this.sousDepartement = sousDepartement;
        this.numEntreprise = numEntreprise;
        this.adresse = adresse;
        this.lien = lien;
        this.contac1=contac1;
        this.contact2=contact2;
    }

    public Publisher(String departement, String sousDepartement, String numEntreprise, String adresse, String lien, String email1, String telephone1, String mdp, Contact contac1, Contact contact2) {
        this.departement = departement;
        this.sousDepartement = sousDepartement;
        this.numEntreprise = numEntreprise;
        this.adresse = adresse;
        this.lien = lien;
        this.email1 = email1;
        this.telephone1 = telephone1;
        this.mdp = mdp;
        this.contac1 = contac1;
        this.contact2 = contact2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Contact getContac1() {
        return contac1;
    }

    public void setContac1(Contact contac1) {
        this.contac1 = contac1;
    }

    public Contact getContact2() {
        return contact2;
    }

    public void setContact2(Contact contact2) {
        this.contact2 = contact2;
    }
}
