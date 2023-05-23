package models;

public class Candidature {

    private String candidat;
    private String refAnnonce;
    private String employeur;
    private String date;
    private String status;
    private String cvUri;
    private String nomEmploi;
    private String adress;

    public Candidature(){}

    public Candidature(String candidat, String refAnnonce, String employeur, String date, String status,String cvUri, String nomEmploi, String adress) {
        this.candidat = candidat;
        this.refAnnonce = refAnnonce;
        this.employeur = employeur;
        this.date = date;
        this.status = status;
        this.cvUri = cvUri;
        this.nomEmploi = nomEmploi;
        this.adress=adress;
    }

    public String getCandidat() {
        return candidat;
    }

    public void setCandidat(String candidat) {
        this.candidat = candidat;
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
}
