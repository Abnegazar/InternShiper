package com.stage.geststage.dto.linked;

import com.stage.geststage.dto.unlinked.UnlinkedOffreDto;
import com.stage.geststage.dto.unlinked.UnlinkedUtilisateurDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LinkedVilleDto implements Serializable {
    private final int codePostal;
    private final String nom;
    private final List<UnlinkedOffreDto> offres;
    private final List<UnlinkedUtilisateurDto> utilisateurs;
}
