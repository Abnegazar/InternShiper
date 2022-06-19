package com.stage.geststage.dto.add;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AddThemeDto implements Serializable {
    private final Long id;
    private final String libelle;
    private final List<Long> offreIds;
    private final List<Long> utilisateurIds;
}
