package com.stage.geststage.mapper.unlinked;

import com.stage.geststage.domain.Theme;
import com.stage.geststage.domain.Ville;
import com.stage.geststage.dto.unlinked.UnlinkedThemeDto;
import com.stage.geststage.dto.unlinked.UnlinkedVilleDto;

public class VilleUnlinkedMapper {
    public UnlinkedThemeDto toUnlinkedDto(Theme theme) {
        long id = theme.getId();
        String libelle = theme.getLibelle();

        return new UnlinkedThemeDto(id, libelle);
    }

    public UnlinkedVilleDto toUnlinkedDto(Ville ville) {
        long id = ville.getId();
        String nom = ville.getNom();
        int codePostal = ville.getCodePostal();

        return new UnlinkedVilleDto(id, codePostal, nom);
    }
}
