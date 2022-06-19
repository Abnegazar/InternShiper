package com.stage.geststage.dto.add;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AddVilleDto implements Serializable {
    private final int codePostal;
    private final String nom;
    private final List<Long> offreIds;
    private final List<Long> utilisateurIds;
}
