package models;

import java.io.Serializable;

public class Employeur extends Publisher implements Serializable  {
    private String nomEntreprise;
    public Employeur() {
        super();
    }

    public Employeur( String nomEntreprise, String departement, String sousDepartement, String numEntreprise, String adresse, String lien, Contact contac1, Contact contact2) {
        super(departement, sousDepartement, numEntreprise, adresse, lien, contac1, contact2);
        this.nomEntreprise = nomEntreprise;
    }

    public Employeur(String departement, String sousDepartement, String numEntreprise, String adresse, String lien, String email1, String telephone1, String mdp, Contact contac1, Contact contact2, String nomEntreprise) {
        super(departement, sousDepartement, numEntreprise, adresse, lien, email1, telephone1, mdp, contac1, contact2);
        this.nomEntreprise = nomEntreprise;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }
}
