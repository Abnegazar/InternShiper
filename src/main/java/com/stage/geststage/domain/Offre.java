package com.stage.geststage.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Offre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String titre;
    private String descriptionStage;
    private String descriptionEntreprise;
    private String niveauRequis;
    private String disponibilite;
    private Long salaire;

    @ManyToOne
    @JoinColumn(name = "ville")
    private Ville ville;

    @ManyToMany(mappedBy = "offres")
    @ToString.Exclude
    private List<Competence> competences = new ArrayList<>();

    @ManyToMany(mappedBy = "offres")
    @ToString.Exclude
    private List<Theme> themes = new ArrayList<>();

    public Offre(String titre, String descriptionStage, String descriptionEntreprise, String niveauRequis, String disponibilite, Long salaire) {
        this.titre = titre;
        this.descriptionStage = descriptionStage;
        this.descriptionEntreprise = descriptionEntreprise;
        this.niveauRequis = niveauRequis;
        this.disponibilite = disponibilite;
        this.salaire = salaire;
    }

    public void ajouterCompetence(Competence competence) {
        competences.add(competence);
        competence.getOffres().add(this);
    }
}