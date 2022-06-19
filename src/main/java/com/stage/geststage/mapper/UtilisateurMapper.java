package com.stage.geststage.mapper;

import com.stage.geststage.domain.Utilisateur;
import com.stage.geststage.dto.add.AddUtilisateurDto;
import com.stage.geststage.dto.linked.LinkedUtilisateurDto;
import com.stage.geststage.dto.unlinked.UnlinkedEcoleDto;
import com.stage.geststage.dto.unlinked.UnlinkedThemeDto;
import com.stage.geststage.dto.unlinked.UnlinkedVilleDto;
import com.stage.geststage.mapper.unlinked.EcoleUnlinkedMapper;
import com.stage.geststage.mapper.unlinked.ThemeUnlinkedMapper;
import com.stage.geststage.mapper.unlinked.VilleUnlinkedMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UtilisateurMapper {
    EcoleUnlinkedMapper ecoleUnlinkedMapper = new EcoleUnlinkedMapper();
    VilleUnlinkedMapper villeUnlinkedMapper = new VilleUnlinkedMapper();
    ThemeUnlinkedMapper themeUnlinkedMapper = new ThemeUnlinkedMapper();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public LinkedUtilisateurDto toDto(Utilisateur utilisateur) {
        String nom = utilisateur.getNom();
        String prenom = utilisateur.getPrenom();
        String role = utilisateur.getRole();
        String mail = utilisateur.getMail();
        String password = utilisateur.getPassword();
        int codePostal = utilisateur.getCodePostal();
        String civilite = utilisateur.getCivilite();
        String dateNaissance = formatter.format(utilisateur.getDateNaissance());
        String status = utilisateur.getStatus();

        UnlinkedEcoleDto ecoleDto = ecoleUnlinkedMapper.toUnlinkedDto(utilisateur.getEcole());
        UnlinkedVilleDto villeDto = villeUnlinkedMapper.toUnlinkedDto(utilisateur.getVille());
        List<UnlinkedThemeDto> themeDtos = utilisateur
                .getFavoris()
                .stream()
                .map(theme -> themeUnlinkedMapper.toUnlinkedDto(theme))
                .toList();

        return new LinkedUtilisateurDto(nom, prenom, role, mail, password, codePostal, civilite, dateNaissance, status, ecoleDto, villeDto, themeDtos);
    }

    public Utilisateur toUtilisateur(AddUtilisateurDto utilisateurDto) {
        return new Utilisateur(utilisateurDto.getNom(),
                utilisateurDto.getPrenom(),
                utilisateurDto.getRole(),
                utilisateurDto.getMail(),
                utilisateurDto.getPassword(),
                utilisateurDto.getCodePostal(),
                utilisateurDto.getCivilite(),
                LocalDate.parse(utilisateurDto.getDateNaissance(), formatter),
                utilisateurDto.getStatus());
    }
}
