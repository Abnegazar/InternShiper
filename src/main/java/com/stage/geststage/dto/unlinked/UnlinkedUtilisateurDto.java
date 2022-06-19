package com.stage.geststage.dto.unlinked;

import lombok.Data;

import java.io.Serializable;

@Data
public class UnlinkedUtilisateurDto implements Serializable {
    private final Long id;
    private final String nom;
    private final String prenom;
    private final String role;
    private final String mail;
    private final String password;
    private final int codePostal;
    private final String civilite;
    private final String dateNaissance;
    private final String status;
}
