package plateformeStage.grp.plateformeStage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plateformeStage.grp.plateformeStage.entity.DemandeStage;

@Repository
public interface DemandeStageRepository extends JpaRepository<DemandeStage, Long> {

    // Exemple de méthode personnalisée (à décommenter si tu as un champ étudiant)
    // List<DemandeStage> findByEtudiantId(Long etudiantId);

}
