package mesEmploiRecyclerView;


public class ItemEmploi {

    private String nomEmploi;
    private String entreprise;
    private String adress;
    private String date;

    public ItemEmploi(){
    }

    public ItemEmploi(String nomEmploi, String entreprise, String adress,String date) {
        this.nomEmploi = nomEmploi;
        this.entreprise = entreprise;
        this.adress = adress;
        this.date = date;
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
}
