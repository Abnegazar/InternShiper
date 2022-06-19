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
public class Theme implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String libelle;

    @ManyToMany
    private List<Offre> offres = new ArrayList<>();

    @ManyToMany
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    public Theme(String libelle) {
        this.libelle = libelle;
    }

    public void ajouterOffre(Offre offre) {
        offres.add(offre);
        offre.getThemes().add(this);
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
        utilisateur.getFavoris().add(this);
    }

}
