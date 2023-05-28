package models;

public class HistoriqueOffre {
    private String nomEmploi;
    private String datePublication;
    private String ref;
    private String publisher;

    public HistoriqueOffre(){
    }

    public HistoriqueOffre(String nomEmploi, String datePublication, String ref,String publisher) {
        this.nomEmploi = nomEmploi;
        this.datePublication = datePublication;
        this.ref = ref;
        this.publisher = publisher;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
