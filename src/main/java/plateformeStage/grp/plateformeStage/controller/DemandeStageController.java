package plateformeStage.grp.plateformeStage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import plateformeStage.grp.plateformeStage.dto.DemandeStageRequest;
import plateformeStage.grp.plateformeStage.entity.DemandeStage;
import plateformeStage.grp.plateformeStage.entity.Etudiant;
import plateformeStage.grp.plateformeStage.mapper.DemandeStageMapper;
import plateformeStage.grp.plateformeStage.repository.DemandeStageRepository;
import plateformeStage.grp.plateformeStage.repository.EtudiantRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/demandes")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeStageController {

    @Autowired
    private DemandeStageRepository demandeStageRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    // Méthode modifiée pour consommer du JSON avec @RequestBody
    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> recevoirDemande(@RequestBody DemandeStageRequest demande) {
        try {
            // Vérifier si l'étudiant existe
            Optional<Etudiant> etudiantOpt = etudiantRepository.findByEmailInstitutionnel(demande.getEmail());
            if (etudiantOpt.isEmpty()) {
                return ResponseEntity.ok("⚠️ Aucun étudiant trouvé avec cet email. Demande non enregistrée.");
            }
            DemandeStage demandeStage = DemandeStageMapper.toEntity(demande);
            demandeStage.setEtudiant(etudiantOpt.get());

            DemandeStage addedDemandeStage = demandeStageRepository.save(demandeStage);

            return ResponseEntity.ok(addedDemandeStage.getId().toString());

        } catch (Exception e) {
            return ResponseEntity.ok("Erreur interne : " + e.getMessage());
        }
    }
}
