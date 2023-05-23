package mesCandidatureRecyclerView;

public class ItemCandidature {

    private String nomEmploi;
    private String nomEntreprise;
    private String adress;
    private String date;

    public ItemCandidature(){}

    public ItemCandidature(String nomEmploi, String nomEntreprise, String adress, String date) {
        this.nomEmploi = nomEmploi;
        this.nomEntreprise = nomEntreprise;
        this.adress = adress;
        this.date = date;
    }

    public String getNomEmploi() {
        return nomEmploi;
    }

    public void setNomEmploi(String nomEmploi) {
        this.nomEmploi = nomEmploi;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
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
}
