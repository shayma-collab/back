package plateformeStage.grp.plateformeStage.service;

import org.springframework.stereotype.Service;
import plateformeStage.grp.plateformeStage.entity.DemandeStage;
import plateformeStage.grp.plateformeStage.repository.DemandeStageRepository;

import java.util.List;

@Service
public class DemandeStageService {

    private final DemandeStageRepository repository;

    public DemandeStageService(DemandeStageRepository repository) {
        this.repository = repository;
    }

    public DemandeStage create(DemandeStage demande) {
        return repository.save(demande);
    }

    public List<DemandeStage> getAll() {
        return repository.findAll();
    }
}
