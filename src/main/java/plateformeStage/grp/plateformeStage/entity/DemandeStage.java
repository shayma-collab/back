package plateformeStage.grp.plateformeStage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DemandeStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateFin;

    private String entreprise;
    private String sujet;
    private String organismeAccueil;
    private String departement;
    private String responsableDirect;
    private String fonctionResponsableDirect;
    private String adresse;
    private String fax;
    private String tel;
    private String email;

    private String etat;

    @ManyToOne
    private OffreStage offreStage;

    @ManyToOne
    private Etudiant etudiant;

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public OffreStage getOffreStage() {
        return offreStage;
    }

    public void setOffreStage(OffreStage offreStage) {
        this.offreStage = offreStage;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
