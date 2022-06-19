package com.stage.geststage.mapper.unlinked;

import com.stage.geststage.domain.Competence;
import com.stage.geststage.dto.unlinked.UnlinkedCompetenceDto;

public class CompetenceUnlinkedMapper {
    public UnlinkedCompetenceDto toUnlinkedDto(Competence competence) {
        long id = competence.getId();
        String label = competence.getLabel();

        return new UnlinkedCompetenceDto(id, label);
    }
}
