package plateformeStage.grp.plateformeStage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plateformeStage.grp.plateformeStage.entity.OffreStage;
import plateformeStage.grp.plateformeStage.repository.OffreStageRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offres")
@CrossOrigin(origins = "*")
public class OffreStageController {

    @Autowired
    private OffreStageRepository offreStageRepository;

    // GET toutes les offres
    @GetMapping
    public List<OffreStage> getAllOffres() {
        return offreStageRepository.findAll();
    }

    // GET une offre par ID
    @GetMapping("/{id}")
    public ResponseEntity<OffreStage> getOffreById(@PathVariable Long id) {
        Optional<OffreStage> offre = offreStageRepository.findById(id);
        return offre.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // POST créer une offre
    @PostMapping
    public OffreStage createOffre(@RequestBody OffreStage offreStage) {
        return offreStageRepository.save(offreStage);
    }

    // PUT modifier une offre
    @PutMapping("/{id}")
    public ResponseEntity<OffreStage> updateOffre(@PathVariable Long id, @RequestBody OffreStage details) {
        return offreStageRepository.findById(id).map(offre -> {
            offre.setTitre(details.getTitre());
            offre.setEntreprise(details.getEntreprise());
            offre.setSujet(details.getSujet());
            offre.setDescription(details.getDescription());
            offre.setLieu(details.getLieu());
            offre.setDuree(details.getDuree());
            offre.setDatePublication(details.getDatePublication());
            offre.setDateDebut(details.getDateDebut());
            offre.setDateFin(details.getDateFin());
            offre.setEtat(details.getEtat());
            offre.setOrganismeAccueil(details.getOrganismeAccueil());
            offre.setDepartement(details.getDepartement());
            offre.setResponsableDirect(details.getResponsableDirect());
            offre.setFonctionResponsableDirect(details.getFonctionResponsableDirect());

            OffreStage updated = offreStageRepository.save(offre);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE supprimer une offre
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffre(@PathVariable Long id) {
        return offreStageRepository.findById(id).map(offre -> {
            offreStageRepository.delete(offre);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
