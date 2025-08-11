package plateformeStage.grp.plateformeStage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plateformeStage.grp.plateformeStage.entity.DemandeStage;
import plateformeStage.grp.plateformeStage.entity.Etudiant;
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

    @PostMapping
    public ResponseEntity<String> recevoirDemande(@RequestBody DemandeStage demande) {
        try {
            // 1️⃣ Vérifier si l'étudiant existe
            Optional<Etudiant> etudiantOpt = etudiantRepository.findByEmail(demande.getEmail());
            if (etudiantOpt.isEmpty()) {
                // ✅ Retourne toujours 200 mais avec un message clair
                return ResponseEntity.ok("⚠️ Aucun étudiant trouvé avec cet email. Demande non enregistrée.");
            }

            // 2️⃣ Associer l'étudiant trouvé
            demande.setEtudiant(etudiantOpt.get());

            // 3️⃣ Sauvegarder en BDD
            demandeStageRepository.save(demande);

            return ResponseEntity.ok("✅ Demande enregistrée avec succès");

        } catch (Exception e) {
            // ✅ Même pour les erreurs, on retourne 200 mais avec message
            return ResponseEntity.ok("❌ Erreur interne : " + e.getMessage());
        }
    }
}
