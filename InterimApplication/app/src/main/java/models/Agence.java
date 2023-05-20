package models;

public class Agence extends Publisher{
    private String nomAgence;
    public Agence() {
        super();
    }

    public Agence(String departement, String sousDepartement, String numEntreprise, String adresse, String lien, Contact contac1, Contact contact2, String nomAgence) {
        super(departement, sousDepartement, numEntreprise, adresse, lien, contac1, contact2);
        this.nomAgence = nomAgence;
    }

    public Agence(String departement, String sousDepartement, String numEntreprise, String adresse, String lien, String email1, String telephone1, String mdp, Contact contac1, Contact contact2, String nomAgence) {
        super(departement, sousDepartement, numEntreprise, adresse, lien, email1, telephone1, mdp, contac1, contact2);
        this.nomAgence = nomAgence;
    }
    public String getNomAgence() {
        return nomAgence;
    }
    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }
}
