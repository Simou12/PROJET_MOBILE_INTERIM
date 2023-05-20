package models;

public class Offre {
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
    private Publisher publisher;

    public Offre() {}

    public Offre(String ref, String nom, String description, long remunerationMensuelle, long remunerationHoraire, String typeContrat, String dateDeb, String dateFin, Publisher publisher, String pays,String ville) {
        this.ref = ref;
        this.nom = nom;
        this.description = description;
        this.remunerationMensuelle = remunerationMensuelle;
        this.remunerationHoraire = remunerationHoraire;
        this.typeContrat = typeContrat;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.publisher = publisher;
        this.pays=pays;
        this.ville=ville;
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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
