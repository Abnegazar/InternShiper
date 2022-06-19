package com.stage.geststage.mapper.unlinked;

import com.stage.geststage.domain.Utilisateur;
import com.stage.geststage.dto.unlinked.UnlinkedUtilisateurDto;

import java.time.format.DateTimeFormatter;

public class UtilisateurUnlinkedMapper {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public UnlinkedUtilisateurDto toUnlinkedDto(Utilisateur utilisateur) {
        long id = utilisateur.getId();
        String nom = utilisateur.getNom();
        String prenom = utilisateur.getPrenom();
        String role = utilisateur.getRole();
        String mail = utilisateur.getMail();
        String password = utilisateur.getPassword();
        int codePostal = utilisateur.getCodePostal();
        String civilite = utilisateur.getCivilite();
        String dateNaissance = formatter.format(utilisateur.getDateNaissance());
        String status = utilisateur.getStatus();

        return new UnlinkedUtilisateurDto(id, nom, prenom, role, mail, password, codePostal, civilite, dateNaissance, status);
    }
}
