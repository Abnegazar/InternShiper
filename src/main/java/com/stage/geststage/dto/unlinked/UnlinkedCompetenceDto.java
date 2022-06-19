package com.stage.geststage.dto.unlinked;

import lombok.Data;

import java.io.Serializable;

@Data
public class UnlinkedCompetenceDto implements Serializable {
    private final Long id;
    private final String label;
}
