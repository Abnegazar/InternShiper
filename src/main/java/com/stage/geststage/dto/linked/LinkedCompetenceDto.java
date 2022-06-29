package com.stage.geststage.dto.linked;

import com.stage.geststage.dto.unlinked.UnlinkedOffreDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LinkedCompetenceDto implements Serializable {
    private final Long id;
    private final String label;
    private final List<UnlinkedOffreDto> offres;
}
