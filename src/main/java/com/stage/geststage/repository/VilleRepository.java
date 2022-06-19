package com.stage.geststage.repository;

import com.stage.geststage.domain.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VilleRepository extends JpaRepository<Ville, Long> {

    List<Ville> findAllByCodePostalOrderByCodePostalAsc(int code);

    List<Ville> findAllByNomContainingIgnoreCaseOrderByNomAsc(String nom);
}
