package com.stage.geststage.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;
    private String prenom;
    private String role;
    private String mail;
    private String password;
    private int codePostal;
    private String civilite;
    private LocalDate dateNaissance;
    private String status;

    @ManyToOne
    @JoinColumn(name = "ecole_id")
    private Ecole ecole;

    @ManyToOne
    @JoinColumn(name = "ville_id")
    private Ville ville;

    @ManyToMany(mappedBy = "utilisateurs")
    @ToString.Exclude
    private List<Theme> favoris = new ArrayList<>();

    @Transient
    private String nomPrenom;

    public Utilisateur(String nom, String prenom, String role, String mail, String password, int codePostal, String civilite, LocalDate dateNaissance, String status) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.mail = mail;
        this.password = password;
        this.codePostal = codePostal;
        this.civilite = civilite;
        this.dateNaissance = dateNaissance;
        this.status = status;
    }

    public void ajouterFavoris(Theme theme) {
        favoris.add(theme);
        theme.getUtilisateurs().add(this);
    }

    public void ajouterEcole(Ecole ecole) {
        this.setEcole(ecole);
        ecole.getUtilisateurs().add(this);
    }

    public void ajouterVille(Ville ville) {
        this.setVille(ville);
        ville.getUtilisateurs().add(this);
    }

}