package plateformeStage.grp.plateformeStage.mapper;

import plateformeStage.grp.plateformeStage.dto.DemandeStageDto;
import plateformeStage.grp.plateformeStage.entity.DemandeStage;

public final class DemandeStageMapper {

    private DemandeStageMapper() {
    }

    public static DemandeStage toEntity(DemandeStageDto dto) {
        if (dto == null) return null;

        DemandeStage entity = new DemandeStage();
        entity.setId(dto.getId());
        entity.setEntreprise(dto.getEntreprise());
        entity.setSujet(dto.getSujet());
        entity.setDateDebut(dto.getDateDebut());
        entity.setDateFin(dto.getDateFin());
        entity.setEtat(dto.getEtat());

        entity.setOrganismeAccueil(dto.getOrganismeAccueil());
        entity.setDepartement(dto.getDepartement());
        entity.setResponsableDirect(dto.getResponsableDirect());
        entity.setFonctionResponsableDirect(dto.getFonctionResponsableDirect());
        entity.setAdresse(dto.getAdresse());
        entity.setFax(dto.getFax());
        entity.setTel(dto.getTel());
        entity.setEmail(dto.getEmail());

        return entity;
    }

    public static DemandeStageDto toDto(DemandeStage entity) {
        if (entity == null) return null;

        DemandeStageDto dto = new DemandeStageDto();
        dto.setId(entity.getId());
        dto.setEntreprise(entity.getEntreprise());
        dto.setSujet(entity.getSujet());
        dto.setDateDebut(entity.getDateDebut());
        dto.setDateFin(entity.getDateFin());
        dto.setEtat(entity.getEtat());

        dto.setOrganismeAccueil(entity.getOrganismeAccueil());
        dto.setDepartement(entity.getDepartement());
        dto.setResponsableDirect(entity.getResponsableDirect());
        dto.setFonctionResponsableDirect(entity.getFonctionResponsableDirect());
        dto.setAdresse(entity.getAdresse());
        dto.setFax(entity.getFax());
        dto.setTel(entity.getTel());
        dto.setEmail(entity.getEmail());

        return dto;
    }
}
