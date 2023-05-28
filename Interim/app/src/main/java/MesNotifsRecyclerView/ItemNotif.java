package MesNotifsRecyclerView;

public class ItemNotif {

    private String metier;
    private String employeur;
    private String adress;
    private  String status;
    private String ref;

    public ItemNotif(){}

    public ItemNotif(String metier, String employeur, String adress, String status, String ref) {
        this.metier = metier;
        this.employeur = employeur;
        this.adress = adress;
        this.status = status;
        this.ref = ref;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public String getEmployeur() {
        return employeur;
    }

    public void setEmployeur(String employeur) {
        this.employeur = employeur;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}

