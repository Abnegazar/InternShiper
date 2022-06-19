package com.stage.geststage;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UnlinkedPayementDto implements Serializable {
    private final PayementIdDto id;
    private final LocalDate datePayement;
    private final Long montant;
    private final String moyenDePayement;

    @Data
    public static class PayementIdDto implements Serializable {
        private final Long userId;
        private final Long offreId;
    }
}
