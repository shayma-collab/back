package plateformeStage.grp.plateformeStage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plateformeStage.grp.plateformeStage.entity.Etudiant;
import plateformeStage.grp.plateformeStage.repository.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiants")
@CrossOrigin(origins = "*")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    // GET tous les étudiants
    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    // GET un étudiant par ID
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        return etudiant.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // POST créer un étudiant
    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    // PUT modifier un étudiant
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiantDetails) {
        return etudiantRepository.findById(id).map(etudiant -> {
            etudiant.setNom(etudiantDetails.getNom());
            etudiant.setPrenom(etudiantDetails.getPrenom());
            etudiant.setEmailInstitutionnel(etudiantDetails.getEmailInstitutionnel());
            etudiant.setNiveau(etudiantDetails.getNiveau());
            etudiant.setDepartement(etudiantDetails.getDepartement());
            etudiant.setSpecialite(etudiantDetails.getSpecialite());
            etudiant.setMotDePasse(etudiantDetails.getMotDePasse());
            Etudiant updated = etudiantRepository.save(etudiant);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE supprimer un étudiant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        return etudiantRepository.findById(id).map(etudiant -> {
            etudiantRepository.delete(etudiant);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
