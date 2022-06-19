package com.stage.geststage.dto.add;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AddCompetenceDto implements Serializable {
    private final String label;
    private final List<Long> offres;
}
