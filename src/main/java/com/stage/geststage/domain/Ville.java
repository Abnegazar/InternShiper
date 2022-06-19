package com.stage.geststage.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int codePostal;
    private String nom;

    @OneToMany(mappedBy = "ville")
    private List<Offre> offres;

    @OneToMany(mappedBy = "ville")
    private List<Utilisateur> utilisateurs;

    public Ville(int codePostal, String nom) {
        this.codePostal = codePostal;
        this.nom = nom;
    }

    public void ajouterEtudiant(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
        utilisateur.setVille(this);
    }

    public void ajouterOffre(Offre offre) {
        offres.add(offre);
        offre.setVille(this);
    }
}
