package com.stage.geststage.mapper;

import com.stage.geststage.domain.Offre;
import com.stage.geststage.dto.add.AddOffreDto;
import com.stage.geststage.dto.linked.LinkedOffreDto;
import com.stage.geststage.dto.unlinked.UnlinkedCompetenceDto;
import com.stage.geststage.dto.unlinked.UnlinkedThemeDto;
import com.stage.geststage.dto.unlinked.UnlinkedVilleDto;
import com.stage.geststage.mapper.unlinked.CompetenceUnlinkedMapper;
import com.stage.geststage.mapper.unlinked.ThemeUnlinkedMapper;
import com.stage.geststage.mapper.unlinked.VilleUnlinkedMapper;

import java.util.List;

public class OffreMapper {

    CompetenceUnlinkedMapper competenceUnlinkedMapper = new CompetenceUnlinkedMapper();
    VilleUnlinkedMapper villeUnlinkedMapper = new VilleUnlinkedMapper();
    ThemeUnlinkedMapper themeUnlinkedMapper = new ThemeUnlinkedMapper();

    public LinkedOffreDto toDto(Offre offre) {
        String titre = offre.getTitre();
        String descriptionStage = offre.getDescriptionStage();
        String descriptionEntreprise = offre.getDescriptionEntreprise();
        String niveauRequis = offre.getNiveauRequis();
        String disponibilite = offre.getDisponibilite();
        Long salaire = offre.getSalaire();
        UnlinkedVilleDto ville = villeUnlinkedMapper.toUnlinkedDto(offre.getVille());
        List<UnlinkedCompetenceDto> competences = offre
                .getCompetences()
                .stream()
                .map(competence -> competenceUnlinkedMapper.toUnlinkedDto(competence))
                .toList();
        List<UnlinkedThemeDto> themes = offre
                .getThemes()
                .stream()
                .map(theme -> themeUnlinkedMapper.toUnlinkedDto(theme))
                .toList();

        return new LinkedOffreDto(titre, descriptionStage, descriptionEntreprise, niveauRequis, disponibilite, salaire, ville, competences, themes);
    }

    public Offre toOffre(AddOffreDto offreDto) {
        return new Offre(offreDto.getTitre(),
                offreDto.getDescriptionStage(),
                offreDto.getDescriptionEntreprise(),
                offreDto.getNiveauRequis(),
                offreDto.getDisponibilite(),
                offreDto.getSalaire());
    }

}
