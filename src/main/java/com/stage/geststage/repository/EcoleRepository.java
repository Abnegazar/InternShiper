package com.stage.geststage.repository;

import com.stage.geststage.domain.Ecole;
import com.stage.geststage.dto.linked.LinkedEcoleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EcoleRepository extends JpaRepository<Ecole, Long> {

    List<LinkedEcoleDto> findAllByNomContainingIgnoreCaseOrderByNomAsc(String nom);

    @Query("SELECT e FROM Ecole AS e JOIN e.utilisateurs as u WHERE u.id = ?1")
    LinkedEcoleDto findEcoleByUtilisateursId(Long userId);
}
