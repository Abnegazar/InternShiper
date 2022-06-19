package com.stage.geststage.mapper;

import com.stage.geststage.domain.Theme;
import com.stage.geststage.dto.add.AddThemeDto;
import com.stage.geststage.dto.linked.LinkedThemeDto;
import com.stage.geststage.dto.unlinked.UnlinkedOffreDto;
import com.stage.geststage.dto.unlinked.UnlinkedUtilisateurDto;
import com.stage.geststage.mapper.unlinked.OffreUnlinkedMapper;
import com.stage.geststage.mapper.unlinked.UtilisateurUnlinkedMapper;

import java.util.List;

public class ThemeMapper {

    OffreUnlinkedMapper offreUnlinkedMapper = new OffreUnlinkedMapper();
    UtilisateurUnlinkedMapper utilisateurUnlinkedMapper = new UtilisateurUnlinkedMapper();

    public LinkedThemeDto toDto(Theme theme) {
        String libelle = theme.getLibelle();
        List<UnlinkedOffreDto> offres = theme
                .getOffres()
                .stream()
                .map(offre -> offreUnlinkedMapper.toUnlinkedDto(offre))
                .toList();
        List<UnlinkedUtilisateurDto> utilisateurs = theme
                .getUtilisateurs()
                .stream()
                .map(utilisateur -> utilisateurUnlinkedMapper.toUnlinkedDto(utilisateur))
                .toList();

        return new LinkedThemeDto(libelle, offres, utilisateurs);
    }

    public Theme toTheme(AddThemeDto dto) {
        return new Theme(dto.getLibelle());
    }
}
