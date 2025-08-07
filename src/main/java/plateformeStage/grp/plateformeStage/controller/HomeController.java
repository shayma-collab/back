package plateformeStage.grp.plateformeStage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import plateformeStage.grp.plateformeStage.entity.DemandeStage;
import plateformeStage.grp.plateformeStage.entity.Etudiant;
import plateformeStage.grp.plateformeStage.entity.OffreStage;
import plateformeStage.grp.plateformeStage.repository.DemandeStageRepository;
import plateformeStage.grp.plateformeStage.repository.EtudiantRepository;
import plateformeStage.grp.plateformeStage.repository.OffreStageRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";  // renvoie vers src/main/resources/templates/home.html (si tu utilises Thymeleaf)
    }
}



