package GestionnaireRecyclerView;

import android.widget.Button;

public class ItemNewInscription {
    String nom;
    String role;
    String adresse;
    String email;
    String tel;
    String numNational;
    String departement;
    String sDeparement;
    String dateInscription;
    int accepterbtn;
    int refuserbtn;
    int local;
    int gmail;
    int phone;

    public ItemNewInscription() {}

    public ItemNewInscription(String nom,String role, String adresse, String email, String tel, String numNational, String departement, String sDeparement, String dateInscription, int accepterbtn, int refuserbtn, int local, int gmail, int phone) {
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.numNational = numNational;
        this.departement = departement;
        this.sDeparement = sDeparement;
        this.dateInscription = dateInscription;
        this.accepterbtn = accepterbtn;
        this.refuserbtn = refuserbtn;
        this.local = local;
        this.gmail = gmail;
        this.phone = phone;
        this.role=role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNumNational() {
        return numNational;
    }

    public void setNumNational(String numNational) {
        this.numNational = numNational;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getsDeparement() {
        return sDeparement;
    }

    public void setsDeparement(String sDeparement) {
        this.sDeparement = sDeparement;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public int getAccepterbtn() {
        return accepterbtn;
    }

    public void setAccepterbtn(int accepterbtn) {
        this.accepterbtn = accepterbtn;
    }

    public int getRefuserbtn() {
        return refuserbtn;
    }

    public void setRefuserbtn(int refuserbtn) {
        this.refuserbtn = refuserbtn;
    }


    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public int getGmail() {
        return gmail;
    }

    public void setGmail(int gmail) {
        this.gmail = gmail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
