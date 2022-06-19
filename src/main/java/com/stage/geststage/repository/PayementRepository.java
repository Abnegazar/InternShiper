package com.stage.geststage.repository;

import com.stage.geststage.domain.Payement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayementRepository extends JpaRepository<Payement, Long> {
}
