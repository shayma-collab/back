package plateformeStage.grp.plateformeStage.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "offres_stage") // optionnel
public class OffreStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String entreprise;
    private String sujet;
    private String description;
    private String lieu;
    private String duree;

    @Column(name = "date_publication")
    private LocalDate datePublication;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    private String etat;  // ex: "en cours", "terminé", etc.

    @Column(name = "organisme_accueil")
    private String organismeAccueil;

    private String departement;

    @Column(name = "responsable_direct")
    private String responsableDirect;

    @Column(name = "fonction_responsable_direct")
    private String fonctionResponsableDirect;

    public OffreStage() {
    }

    public OffreStage(Long id, String titre, String entreprise, String sujet, String description, String lieu,
                      String duree, LocalDate datePublication, LocalDate dateDebut, LocalDate dateFin, String etat,
                      String organismeAccueil, String departement, String responsableDirect, String fonctionResponsableDirect) {
        this.id = id;
        this.titre = titre;
        this.entreprise = entreprise;
        this.sujet = sujet;
        this.description = description;
        this.lieu = lieu;
        this.duree = duree;
        this.datePublication = datePublication;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
        this.organismeAccueil = organismeAccueil;
        this.departement = departement;
        this.responsableDirect = responsableDirect;
        this.fonctionResponsableDirect = fonctionResponsableDirect;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
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
}
