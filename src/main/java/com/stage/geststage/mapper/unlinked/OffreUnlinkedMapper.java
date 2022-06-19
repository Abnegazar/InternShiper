package com.stage.geststage.mapper.unlinked;

import com.stage.geststage.domain.Offre;
import com.stage.geststage.dto.unlinked.UnlinkedOffreDto;

public class OffreUnlinkedMapper {

    public UnlinkedOffreDto toUnlinkedDto(Offre offre) {
        long id = offre.getId();
        String titre = offre.getTitre();
        String descriptionStage = offre.getDescriptionStage();
        String descriptionEntreprise = offre.getDescriptionEntreprise();
        String niveauRequis = offre.getNiveauRequis();
        String disponibilite = offre.getDisponibilite();
        Long salaire = offre.getSalaire();

        return new UnlinkedOffreDto(id, titre, descriptionStage, descriptionEntreprise, niveauRequis, disponibilite, salaire);
    }
}
