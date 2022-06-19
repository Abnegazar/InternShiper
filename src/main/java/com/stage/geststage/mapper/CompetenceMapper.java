package com.stage.geststage.mapper;

import com.stage.geststage.domain.Competence;
import com.stage.geststage.dto.add.AddCompetenceDto;
import com.stage.geststage.dto.linked.LinkedCompetenceDto;
import com.stage.geststage.dto.unlinked.UnlinkedOffreDto;
import com.stage.geststage.mapper.unlinked.OffreUnlinkedMapper;

import java.util.List;

public class CompetenceMapper {

    OffreUnlinkedMapper offreUnlinkedMapper = new OffreUnlinkedMapper();

    public LinkedCompetenceDto toDto(Competence competence) {
        String label = competence.getLabel();
        List<UnlinkedOffreDto> offres = competence
                .getOffres()
                .stream()
                .map(offre -> offreUnlinkedMapper.toUnlinkedDto(offre))
                .toList();

        return new LinkedCompetenceDto(label, offres);
    }

    public Competence toCompetence(AddCompetenceDto dto) {
        return new Competence(dto.getLabel());
    }
}
