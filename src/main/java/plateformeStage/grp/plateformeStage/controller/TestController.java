package plateformeStage.grp.plateformeStage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/test-db")
    public String testDb() {
        try (Connection conn = dataSource.getConnection()) {
            return "✅ Connexion réussie à la base: " + conn.getCatalog();
        } catch (SQLException e) {
            return "❌ Erreur de connexion: " + e.getMessage();
        }
    }
}
