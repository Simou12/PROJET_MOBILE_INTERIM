package models;

import java.io.Serializable;

public class Favoris implements Serializable {
    private String ref;
    private String nom;
    private String description;
    private long remunerationMensuelle;
    private long remunerationHoraire;
    private String typeContrat;
    private String dateDeb;
    private String dateFin;
    private String adress;
    private String publisher;
    private String datePublication;
    private String entreprise;
    private String candidatEmail;

    public Favoris(){}

    public Favoris(String candidatEmail,String ref, String nom, String description, long remunerationMensuelle, long remunerationHoraire, String typeContrat, String dateDeb, String dateFin, String publisher,String adress, String datePublication, String entreprise) {
        this.candidatEmail = candidatEmail;
        this.ref = ref;
        this.nom = nom;
        this.description = description;
        this.remunerationMensuelle = remunerationMensuelle;
        this.remunerationHoraire = remunerationHoraire;
        this.typeContrat = typeContrat;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.publisher = publisher;
        this.adress=adress;
        this.datePublication = datePublication;
        this.entreprise = entreprise;
    }

    public String getCandidatEmail() {
        return candidatEmail;
    }

    public void setCandidatEmail(String candidatEmail) {
        this.candidatEmail = candidatEmail;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getRemunerationMensuelle() {
        return remunerationMensuelle;
    }

    public void setRemunerationMensuelle(long remunerationMensuelle) {
        this.remunerationMensuelle = remunerationMensuelle;
    }

    public long getRemunerationHoraire() {
        return remunerationHoraire;
    }

    public void setRemunerationHoraire(long remunerationHoraire) {
        this.remunerationHoraire = remunerationHoraire;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public String getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(String dateDeb) {
        this.dateDeb = dateDeb;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
}
