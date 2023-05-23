package MesNotifsRecyclerView;

public class ItemNotif {

    private String metier;
    private String employeur;
    private String adress;

    public ItemNotif(){}

    public ItemNotif(String metier, String employeur, String adress) {
        this.metier = metier;
        this.employeur = employeur;
        this.adress = adress;
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
}
