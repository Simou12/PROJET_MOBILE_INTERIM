package candidatureEnCoursEmplRecyclerView;

public class ItemCandidatureEmpl {

    private String nomCandidat;
    private String prenomCandidat;
    private String emailCandidat;
    private String dateCandidature;

    public ItemCandidatureEmpl(){}

    public ItemCandidatureEmpl(String nomCandidat, String prenomCandidat, String emailCandidat,String dateCandidature) {
        this.dateCandidature = dateCandidature;
        this.nomCandidat = nomCandidat;
        this.prenomCandidat = prenomCandidat;
        this.emailCandidat = emailCandidat;
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
}
