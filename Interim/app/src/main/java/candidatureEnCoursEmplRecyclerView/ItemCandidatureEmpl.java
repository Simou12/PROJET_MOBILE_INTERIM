package candidatureEnCoursEmplRecyclerView;

public class ItemCandidatureEmpl {

    private String nomCandidat;
    private String prenomCandidat;
    private String emailCandidat;
    private String dateCandidature;
    private String nationalite;
    private String adress;
    private String ref;
    private String dateNaissance,lettre;


    public ItemCandidatureEmpl(){}

    public ItemCandidatureEmpl(String nomCandidat, String prenomCandidat, String emailCandidat,String dateCandidature, String nationalite,String adress,String dateNaissance, String lettre, String ref) {
        this.dateCandidature = dateCandidature;
        this.nomCandidat = nomCandidat;
        this.prenomCandidat = prenomCandidat;
        this.emailCandidat = emailCandidat;
        this.nationalite = nationalite;
        this.adress = adress;
        this.dateNaissance= dateNaissance;
        this.lettre = lettre;
        this.ref = ref;
    }

    public String getDateCandidature() {
        return dateCandidature;
    }

    public void setDateCandidature(String dateCandidature) {
        this.dateCandidature = dateCandidature;
    }

    public String getNomCandidat() {
        return nomCandidat;
    }

    public void setNomCandidat(String nomCandidat) {
        this.nomCandidat = nomCandidat;
    }

    public String getPrenomCandidat() {
        return prenomCandidat;
    }

    public void setPrenomCandidat(String prenomCandidat) {
        this.prenomCandidat = prenomCandidat;
    }

    public String getEmailCandidat() {
        return emailCandidat;
    }

    public void setEmailCandidat(String emailCandidat) {
        this.emailCandidat = emailCandidat;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLettre() {
        return lettre;
    }

    public void setLettre(String lettre) {
        this.lettre = lettre;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
