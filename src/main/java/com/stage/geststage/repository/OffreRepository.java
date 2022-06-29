package com.stage.geststage.repository;

import com.stage.geststage.domain.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Long> {

    List<Offre> findAllByTitreContainingIgnoreCase(String titre);

    List<Offre> findAllBySalaireBetweenOrderBySalaireDesc(Long s1, Long s2);

    @Query("SELECT o FROM Offre as o JOIN o.themes as t WHERE t.libelle LIKE %:theme% ORDER BY t.libelle ASC")
    List<Offre> findByTheme(@Param("theme") String theme);

    List<Offre> findAllByNiveauRequisContainingIgnoreCase(String niveau);

    List<Offre> findAllByDescriptionStageContainingIgnoreCase(String description);

    @Query("SELECT o FROM Offre as o JOIN o.themes AS t JOIN o.competences AS c WHERE o.descriptionStage LIKE %:cond% OR o.titre LIKE %:cond% OR t.libelle LIKE %:cond% OR c.label LIKE %:cond%")
    List<Offre> findAllByDescriptionStageContainingIgnoreCaseOrCompetencesContainingIgnoreCaseOrTitreContainingIgnoreCaseOrThemesContainingIgnoreCase(String condition);

    Offre findOffreById(Long id);
}
