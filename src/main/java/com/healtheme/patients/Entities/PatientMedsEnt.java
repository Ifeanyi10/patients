package com.healtheme.patients.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientMedsEnt extends BaseEnt {
    String medName;
    String dosageUnit;
    double dosage;
    String notes;
}
