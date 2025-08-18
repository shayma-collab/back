package plateformeStage.grp.plateformeStage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import plateformeStage.grp.plateformeStage.dto.DemandeStageRequest;
import plateformeStage.grp.plateformeStage.entity.DemandeStage;
import plateformeStage.grp.plateformeStage.entity.Etudiant;
import plateformeStage.grp.plateformeStage.mapper.DemandeStageMapper;
import plateformeStage.grp.plateformeStage.repository.DemandeStageRepository;
import plateformeStage.grp.plateformeStage.repository.EtudiantRepository;
import plateformeStage.grp.plateformeStage.service.DemandeStageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/demandes")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeStageController {

    @Autowired
    private DemandeStageRepository demandeStageRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private DemandeStageService demandeStageService;

    // Créer une demande
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> recevoirDemande(@ModelAttribute DemandeStageRequest demande,
                                                  @RequestParam(value = "cvFile", required = false) MultipartFile cvFile) {
        try {
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

    // Récupérer toutes les demandes
    @GetMapping
    public ResponseEntity<List<DemandeStage>> getAllDemandes() {
        return ResponseEntity.ok(demandeStageService.getAll());
    }

    // Supprimer une demande
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemande(@PathVariable Long id) {
        demandeStageRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
