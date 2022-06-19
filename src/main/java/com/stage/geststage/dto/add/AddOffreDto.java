package com.stage.geststage.dto.add;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AddOffreDto implements Serializable {
    private final String titre;
    private final String descriptionStage;
    private final String descriptionEntreprise;
    private final String niveauRequis;
    private final String disponibilite;
    private final Long salaire;
    private final Long villeId;
    private final List<Long> competenceIds;
    private final List<Long> themeIds;
}
