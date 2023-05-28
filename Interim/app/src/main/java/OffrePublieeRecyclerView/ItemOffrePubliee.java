package OffrePublieeRecyclerView;

public class ItemOffrePubliee {

    private String nomEmploi;
    private String datePublication;
    private String ref;

    public ItemOffrePubliee(){
    }

    public ItemOffrePubliee(String nomEmploi, String datePublication, String ref) {
        this.nomEmploi = nomEmploi;
        this.datePublication = datePublication;
        this.ref = ref;
    }

    public String getNomEmploi() {
        return nomEmploi;
    }

    public void setNomEmploi(String nomEmploi) {
        this.nomEmploi = nomEmploi;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
