package models;

public class Emploi {

    private String nomEmploi;
    private String entreprise;
    private String adress;
    private String date;
    private String candidat;

    public Emploi(String nomEmploi, String entreprise, String adress, String date, String candidat) {
        this.nomEmploi = nomEmploi;
        this.entreprise = entreprise;
        this.adress = adress;
        this.date = date;
        this.candidat = candidat;
    }

    public String getNomEmploi() {
        return nomEmploi;
    }

    public void setNomEmploi(String nomEmploi) {
        this.nomEmploi = nomEmploi;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCandidat() {
        return candidat;
    }

    public void setCandidat(String candidat) {
        this.candidat = candidat;
    }
}
