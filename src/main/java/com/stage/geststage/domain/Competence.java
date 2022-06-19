package com.stage.geststage.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String label;

    @ManyToMany
    private List<Offre> offres = new ArrayList<>();

    public Competence(String label) {
        this.label = label;
    }

    public void ajouterOffre(Offre offre) {
        offres.add(offre);
        offre.getCompetences().add(this);
    }

}