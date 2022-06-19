package com.stage.geststage.dto.linked;

import com.stage.geststage.dto.unlinked.UnlinkedCompetenceDto;
import com.stage.geststage.dto.unlinked.UnlinkedThemeDto;
import com.stage.geststage.dto.unlinked.UnlinkedVilleDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LinkedOffreDto implements Serializable {
    private final String titre;
    private final String descriptionStage;
    private final String descriptionEntreprise;
    private final String niveauRequis;
    private final String disponibilite;
    private final Long salaire;
    private final UnlinkedVilleDto ville;
    private final List<UnlinkedCompetenceDto> competences;
    private final List<UnlinkedThemeDto> themes;
}
