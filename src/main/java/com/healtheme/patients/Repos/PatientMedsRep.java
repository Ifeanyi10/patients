package com.healtheme.patients.Repos;

import com.healtheme.patients.Entities.PatientMedsEnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientMedsRep extends JpaRepository<PatientMedsEnt, Long> {
}
