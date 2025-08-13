package plateformeStage.grp.plateformeStage.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DemandeStageRequest {
    private String sujet;
    private String entreprise;
    private String organismeAccueil;
    private String departement;
    private String responsableDirect;
    private String fonctionResponsableDirect;
    private String adresse;
    private String fax;
    private String tel;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateFin;
    public String getSujet() {
        return sujet;
    }
    public void setSujet(String sujet) {
        this.sujet = sujet;
    }
    public String getEntreprise() {
        return entreprise;
    }
    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
    public String getOrganismeAccueil() {
        return organismeAccueil;
    }
    public void setOrganismeAccueil(String organismeAccueil) {
        this.organismeAccueil = organismeAccueil;
    }
    public String getDepartement() {
        return departement;
    }
    public void setDepartement(String departement) {
        this.departement = departement;
    }
    public String getResponsableDirect() {
        return responsableDirect;
    }
    public void setResponsableDirect(String responsableDirect) {
        this.responsableDirect = responsableDirect;
    }
    public String getFonctionResponsableDirect() {
        return fonctionResponsableDirect;
    }
    public void setFonctionResponsableDirect(String fonctionResponsableDirect) {
        this.fonctionResponsableDirect = fonctionResponsableDirect;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    
}
