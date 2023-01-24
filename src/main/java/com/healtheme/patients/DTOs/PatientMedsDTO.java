package com.healtheme.patients.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientMedsDTO {
    long id;
    String medName;
    String dosageUnit;
    double dosage;
    String notes;
    
}
