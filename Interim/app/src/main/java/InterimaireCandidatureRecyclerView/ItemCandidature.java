package InterimaireCandidatureRecyclerView;

public class ItemCandidature {

    private String nomEmploi;
    private String entreprise;
    private String ref;
    private String dateCandidature;
    private  String status;
    private String adress;

    public ItemCandidature(){}

    public ItemCandidature(String nomEmploi, String entreprise, String ref, String dateCandidature, String status, String adresse) {
        this.nomEmploi = nomEmploi;
        this.entreprise = entreprise;
        this.ref = ref;
        this.dateCandidature = dateCandidature;
        this.status=status;
        this.adress = adresse;
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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDateCandidature() {
        return dateCandidature;
    }

    public void setDateCandidature(String dateCandidature) {
        this.dateCandidature = dateCandidature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
