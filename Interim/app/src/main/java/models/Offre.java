package models;

import android.os.Parcelable;

import java.io.Serializable;

public class Offre implements Serializable {

    private int id;
    private String ref;
    private String nom;
    private String description;
    private long remunerationMensuelle;
    private long remunerationHoraire;
    private String typeContrat;
    private String dateDeb;
    private String dateFin;
    private String ville;
    private String pays;
    private String publisher;
    private String datePublication;
    private String entreprise;

    public Offre(){}

    public Offre(String ref, String nom, String description, long remunerationMensuelle, long remunerationHoraire, String typeContrat, String dateDeb, String dateFin, String publisher,String ville, String pays,String datePublication, String entreprise) {
        this.ref = ref;
        this.nom = nom;
        this.description = description;
        this.remunerationMensuelle = remunerationMensuelle;
        this.remunerationHoraire = remunerationHoraire;
        this.typeContrat = typeContrat;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.publisher = publisher;
        this.ville=ville;
        this.pays=pays;
        this.datePublication = datePublication;
        this.entreprise = entreprise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
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
