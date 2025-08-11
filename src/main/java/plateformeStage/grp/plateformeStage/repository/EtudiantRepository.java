package plateformeStage.grp.plateformeStage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import plateformeStage.grp.plateformeStage.entity.Etudiant;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    // Recherche par email institutionnel
    Optional<Etudiant> findByEmailInstitutionnel(String emailInstitutionnel);

    // Recherche par email (champ "email" dans l'entité Etudiant)
    Optional<Etudiant> findByEmail(String email);
}
