package com.stage.geststage.mapper;

import com.stage.geststage.domain.Ville;
import com.stage.geststage.dto.add.AddVilleDto;
import com.stage.geststage.dto.linked.LinkedVilleDto;
import com.stage.geststage.dto.unlinked.UnlinkedOffreDto;
import com.stage.geststage.dto.unlinked.UnlinkedUtilisateurDto;
import com.stage.geststage.mapper.unlinked.OffreUnlinkedMapper;
import com.stage.geststage.mapper.unlinked.UtilisateurUnlinkedMapper;

import java.util.List;

public class VilleMapper {

    OffreUnlinkedMapper offreUnlinkedMapper = new OffreUnlinkedMapper();
    UtilisateurUnlinkedMapper utilisateurUnlinkedMapper = new UtilisateurUnlinkedMapper();

    public LinkedVilleDto toDto(Ville ville) {
        int codePostal = ville.getCodePostal();
        String nom = ville.getNom();
        List<UnlinkedOffreDto> offres = ville
                .getOffres()
                .stream()
                .map(offre -> offreUnlinkedMapper.toUnlinkedDto(offre))
                .toList();
        List<UnlinkedUtilisateurDto> utilisateurs = ville
                .getUtilisateurs()
                .stream()
                .map(utilisateur -> utilisateurUnlinkedMapper.toUnlinkedDto(utilisateur))
                .toList();

        return new LinkedVilleDto(codePostal, nom, offres, utilisateurs);
    }

    public Ville toVille(AddVilleDto dto) {
        return new Ville(dto.getCodePostal(), dto.getNom());
    }
}