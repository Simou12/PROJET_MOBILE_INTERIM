package annonceEmployeurRecyclerView;

public class ItemAnnonce {

    private String NomEmploi, refAnnonce;

    public ItemAnnonce(){}

    public ItemAnnonce(String nomEmploi, String refAnnonce) {
        NomEmploi = nomEmploi;
        this.refAnnonce = refAnnonce;
    }

    public String getNomEmploi() {
        return NomEmploi;
    }

    public void setNomEmploi(String nomEmploi) {
        NomEmploi = nomEmploi;
    }

    public String getRefAnnonce() {
        return refAnnonce;
    }

    public void setRefAnnonce(String refAnnonce) {
        this.refAnnonce = refAnnonce;
    }
}
