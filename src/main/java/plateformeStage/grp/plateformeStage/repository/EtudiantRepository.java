package plateformeStage.grp.plateformeStage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import plateformeStage.grp.plateformeStage.entity.Etudiant;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByEmailInstitutionnel(String emailInstitutionnel);
}
