package com.labfinal.labfinal.entity.repository;

import com.labfinal.labfinal.entity.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
