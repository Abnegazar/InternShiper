package com.stage.geststage.dto.add;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AddPayementDto implements Serializable {
    private final LocalDate datePayement;
    private final Long montant;
    private final String moyenDePayement;
}
