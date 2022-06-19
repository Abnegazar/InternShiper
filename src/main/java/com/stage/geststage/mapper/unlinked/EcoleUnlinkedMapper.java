package com.stage.geststage.mapper.unlinked;

import com.stage.geststage.domain.Ecole;
import com.stage.geststage.dto.unlinked.UnlinkedEcoleDto;

public class EcoleUnlinkedMapper {

    public UnlinkedEcoleDto toUnlinkedDto(Ecole ecole) {
        long id = ecole.getId();
        String nom = ecole.getNom();

        return new UnlinkedEcoleDto(id, nom);
    }
}
