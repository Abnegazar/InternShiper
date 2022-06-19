package com.stage.geststage.dto.unlinked;

import lombok.Data;

import java.io.Serializable;

@Data
public class UnlinkedOffreDto implements Serializable {
    private final Long id;
    private final String titre;
    private final String descriptionStage;
    private final String descriptionEntreprise;
    private final String niveauRequis;
    private final String disponibilite;
    private final Long salaire;
}
