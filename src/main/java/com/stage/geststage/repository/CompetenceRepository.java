package com.stage.geststage.repository;

import com.stage.geststage.domain.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    List<Competence> findAllByLabelContainingIgnoreCaseOrderByLabelAsc(String label);

    Competence findCompetenceById(Long id);
}
