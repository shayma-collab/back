package plateformeStage.grp.plateformeStage.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import plateformeStage.grp.plateformeStage.entity.*;
import plateformeStage.grp.plateformeStage.repository.*;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/demandes")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeStageController {
    @Autowired
    private DemandeStageRepository demandeStageRepository;
    @Autowired private EtudiantRepository etudiantRepository;
    @Autowired private OffreStageRepository offreStageRepository;

    private final String uploadDir = "uploads/";

    @PostMapping
    public ResponseEntity<String> recevoirDemande(
            @RequestParam("email") String email,
            @RequestParam("tel") String tel,
            @RequestParam("dateDebut") String dateDebut,
            @RequestParam("dateFin") String dateFin,
            @RequestParam("entreprise") String entreprise,
            @RequestParam("sujet") String sujet,
            @RequestParam("organismeAccueil") String organismeAccueil,
            @RequestParam("departement") String departement,
            @RequestParam("responsableDirect") String responsableDirect,
            @RequestParam("fonctionResponsableDirect") String fonctionResponsableDirect,
            @RequestParam("adresse") String adresse,
            @RequestParam("offreId") Long offreId,
            @RequestParam(value = "cv", required = false) MultipartFile cvFile
    ) {
        try {
            Optional<Etudiant> etudiantOpt = etudiantRepository.findByEmailInstitutionnel(email);
            if (etudiantOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("❌ Étudiant introuvable !");
            }

            Optional<OffreStage> offreOpt = offreStageRepository.findById(offreId);
            if (offreOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("❌ Offre introuvable !");
            }

            String cvFileName = null;
            if (cvFile != null && !cvFile.isEmpty()) {
                cvFileName = System.currentTimeMillis() + "_" + cvFile.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + cvFileName);
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, cvFile.getBytes());
            }

            DemandeStage demande = new DemandeStage();
            demande.setEmail(email);
            demande.setTel(tel);
            demande.setDateDebut(LocalDate.parse(dateDebut));
            demande.setDateFin(LocalDate.parse(dateFin));
            demande.setEntreprise(entreprise);
            demande.setSujet(sujet);
            demande.setOrganismeAccueil(organismeAccueil);
            demande.setDepartement(departement);
            demande.setResponsableDirect(responsableDirect);
            demande.setFonctionResponsableDirect(fonctionResponsableDirect);
            demande.setAdresse(adresse);
            demande.setEtat("EN_ATTENTE");
            demande.setCvPath(cvFileName);
            demande.setEtudiant(etudiantOpt.get());
            demande.setOffreStage(offreOpt.get());

            demandeStageRepository.save(demande);
            return new ResponseEntity<>("✅ Demande enregistrée avec succès", HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("❌ Erreur lors de l'enregistrement", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
