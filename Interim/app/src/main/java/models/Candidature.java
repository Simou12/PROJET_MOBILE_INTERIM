package models;

import java.sql.SQLData;

public class Candidature {

    private String nomCandidat;
    private String prenomCandidat;
    private String refAnnonce;
    private String employeur;
    private String date;
    private String status;
    private String cvUri;
    private String nomEmploi;
    private String adress;
    private String email;
    private String entreprise;
    private String nationalite, dateNaissance, lettre;

    public Candidature(){}

    public Candidature(String nomCandidat, String prenomCandidat, String refAnnonce, String employeur, String date, String status, String cvUri, String nomEmploi, String adress, String email, String entreprise, String nationalite, String dateNaissance, String lettre) {
        this.nomCandidat = nomCandidat;
        this.prenomCandidat = prenomCandidat;
        this.refAnnonce = refAnnonce;
        this.employeur = employeur;
        this.date = date;
        this.status = status;
        this.cvUri = cvUri;
        this.nomEmploi = nomEmploi;
        this.adress=adress;
        this.email = email;
        this.entreprise = entreprise;
        this.nationalite = nationalite;
        this.dateNaissance = dateNaissance;
        this.lettre = lettre;
    }

    public String getNomCandidat() {
        return nomCandidat;
    }

    public void setNomCandidat(String nomCandidat) {
        this.nomCandidat = nomCandidat;
    }

    public String getPrenomCandidat() {
        return prenomCandidat;
    }

    public void setPrenomCandidat(String prenomCandidat) {
        this.prenomCandidat = prenomCandidat;
    }

    public String getRefAnnonce() {
        return refAnnonce;
    }

    public void setRefAnnonce(String refAnnonce) {
        this.refAnnonce = refAnnonce;
    }

    public String getEmployeur() {
        return employeur;
    }

    public void setEmployeur(String employeur) {
        this.employeur = employeur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCvUri() {
        return cvUri;
    }

    public void setCvUri(String cvUri) {
        this.cvUri = cvUri;
    }

    public String getNomEmploi() {
        return nomEmploi;
    }

    public void setNomEmploi(String nomEmploi) {
        this.nomEmploi = nomEmploi;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLettre() {
        return lettre;
    }

    public void setLettre(String lettre) {
        this.lettre = lettre;
    }

}
