package com.stage.geststage.domain;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payement implements Serializable {
    @EmbeddedId
    private PayementId id;

    private LocalDate datePayement;
    private Long montant;
    private String moyenDePayement;

    public Payement(LocalDate datePayement, Long montant, String moyenDePayement) {
        this.datePayement = datePayement;
        this.montant = montant;
        this.moyenDePayement = moyenDePayement;
    }
}