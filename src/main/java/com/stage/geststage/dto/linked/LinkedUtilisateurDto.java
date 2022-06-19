package com.stage.geststage.dto.linked;

import com.stage.geststage.dto.unlinked.UnlinkedEcoleDto;
import com.stage.geststage.dto.unlinked.UnlinkedThemeDto;
import com.stage.geststage.dto.unlinked.UnlinkedVilleDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LinkedUtilisateurDto implements Serializable {
    private final String nom;
    private final String prenom;
    private final String role;
    private final String mail;
    private final String password;
    private final int codePostal;
    private final String civilite;
    private final String dateNaissance;
    private final String status;
    private final UnlinkedEcoleDto ecole;
    private final UnlinkedVilleDto ville;
    private final List<UnlinkedThemeDto> favoris;
}
