package plateformeStage.grp.plateformeStage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";  // renvoie vers src/main/resources/templates/home.html (si tu utilises Thymeleaf)
    }
}



