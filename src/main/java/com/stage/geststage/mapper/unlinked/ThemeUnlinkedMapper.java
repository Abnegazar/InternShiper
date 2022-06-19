package com.stage.geststage.mapper.unlinked;

import com.stage.geststage.domain.Theme;
import com.stage.geststage.dto.unlinked.UnlinkedThemeDto;

public class ThemeUnlinkedMapper {
    public UnlinkedThemeDto toUnlinkedDto(Theme theme) {
        long id = theme.getId();
        String libelle = theme.getLibelle();

        return new UnlinkedThemeDto(id, libelle);
    }
}
