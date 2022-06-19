package com.stage.geststage.repository;

import com.stage.geststage.domain.Competence;
import com.stage.geststage.dto.linked.LinkedCompetenceDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    List<LinkedCompetenceDto> findAllByLabelContainingIgnoreCaseOrderByLabelAsc(String label);
}
