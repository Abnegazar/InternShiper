package com.stage.geststage.dto.unlinked;

import lombok.Data;

import java.io.Serializable;

@Data
public class UnlinkedVilleDto implements Serializable {
    private final Long id;
    private final int codePostal;
    private final String nom;
}
