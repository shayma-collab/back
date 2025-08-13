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

import java.util.Optional;

@RestController
@RequestMapping("/api/demandes")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeStageController {

    @Autowired
    private DemandeStageRepository demandeStageRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> recevoirDemande(@ModelAttribute DemandeStageRequest demande,
                                                    @RequestParam(value = "cvFile", required = false)  MultipartFile cvFile) {
        try {
            // 1️⃣ Vérifier si l'étudiant existe
            Optional<Etudiant> etudiantOpt = etudiantRepository.findByEmailInstitutionnel(demande.getEmail());
            if (etudiantOpt.isEmpty()) {
                // ✅ Retourne toujours 200 mais avec un message clair
                return ResponseEntity.ok("⚠️ Aucun étudiant trouvé avec cet email. Demande non enregistrée.");
            }
            DemandeStage demandeStage = DemandeStageMapper.toEntity(demande);
            // 2️⃣ Associer l'étudiant trouvé
            demandeStage.setEtudiant(etudiantOpt.get());

            // 3️⃣ Sauvegarder en BDD
            DemandeStage temp= demandeStageRepository.save(demandeStage);

            return ResponseEntity.ok(temp.getId().toString());

        } catch (Exception e) {
            // ✅ Même pour les erreurs, on retourne 200 mais avec message
            return ResponseEntity.ok("Erreur interne : " + e.getMessage());
        }
    }
}
