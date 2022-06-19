package com.stage.geststage.dto.add;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AddUtilisateurDto implements Serializable {
    private final String nom;
    private final String prenom;
    private final String role;
    private final String mail;
    private final String password;
    private final int codePostal;
    private final String civilite;
    private final String dateNaissance;
    private final String status;
    private final Long ecoleId;
    private final Long villeId;
    private final List<Long> favorisIds;
}
