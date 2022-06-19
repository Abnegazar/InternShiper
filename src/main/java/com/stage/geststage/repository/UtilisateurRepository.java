package com.stage.geststage.repository;

import com.stage.geststage.domain.Utilisateur;
import com.stage.geststage.dto.linked.LinkedUtilisateurDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    LinkedUtilisateurDto findUtilisateurByMailAndPassword(String mail, String password);
}
