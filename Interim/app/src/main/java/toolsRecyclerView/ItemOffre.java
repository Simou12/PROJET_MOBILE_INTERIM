package toolsRecyclerView;

public class ItemOffre {
    String nomEmploi,employeur,entreprise,reference,contrat,remuHeure,remuMois,dateDeb,dateFin,description,datePublication,adress;
    public ItemOffre(){}
    public ItemOffre(String nomEmploi, String employeur,String reference, String contrat, String remuHeure, String remuMois, String dateDeb, String dateFin, String description, String datePublication, String adress,String entreprise) {
        this.nomEmploi = nomEmploi;
        this.employeur = employeur;
        this.reference=reference;
        this.contrat = contrat;
        this.remuHeure = remuHeure;
        this.remuMois = remuMois;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.description = description;
        this.datePublication = datePublication;
        this.adress = adress;
        this.entreprise = entreprise;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNomEmploi() {
        return nomEmploi;
    }

    public void setNomEmploi(String nomEmploi) {
        this.nomEmploi = nomEmploi;
    }

    public String getEmployeur() {
        return employeur;
    }

    public void setEmployeur(String employeur) {
        this.employeur = employeur;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public String getRemuHeure() {
        return remuHeure;
    }

    public void setRemuHeure(String remuHeure) {
        this.remuHeure = remuHeure;
    }

    public String getRemuMois() {
        return remuMois;
    }

    public void setRemuMois(String remuMois) {
        this.remuMois = remuMois;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
}