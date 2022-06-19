package com.stage.geststage.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ecole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "ecole")
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    public Ecole(String nom) {
        this.nom = nom;
    }

    public void ajouterEtudiant(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
        utilisateur.setEcole(this);
    }

}