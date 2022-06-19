package com.stage.geststage.dto.linked;

import com.stage.geststage.dto.unlinked.UnlinkedUtilisateurDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LinkedEcoleDto implements Serializable {
    private final String nom;
    private final List<UnlinkedUtilisateurDto> utilisateurs;
}
