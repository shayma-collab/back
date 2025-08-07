package plateformeStage.grp.plateformeStage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etudiants")  // optionnel, tu peux adapter le nom de la table
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String emailInstitutionnel;
    private String niveau;
    private String departement;
    private String specialite;
    private String motDePasse;

    // Constructeur complet
    public Etudiant(Long id, String nom, String prenom, String emailInstitutionnel, String niveau, String departement, String specialite, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.emailInstitutionnel = emailInstitutionnel;
        this.niveau = niveau;
        this.departement = departement;
        this.specialite = specialite;
        this.motDePasse = motDePasse;
    }

    // Constructeur par défaut
    public Etudiant() {
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmailInstitutionnel() {
        return emailInstitutionnel;
    }

    public void setEmailInstitutionnel(String emailInstitutionnel) {
        this.emailInstitutionnel = emailInstitutionnel;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
