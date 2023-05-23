package models;

public class Abonnement {

    private long montant;
    private String type;
    private String proprietaire;

    public Abonnement(){}

    public Abonnement(long montant, String type, String proprietaire) {
        this.montant = montant;
        this.type = type;
        this.proprietaire = proprietaire;
    }

    public long getMontant() {
        return montant;
    }

    public void setMontant(long montant) {
        this.montant = montant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }
}
