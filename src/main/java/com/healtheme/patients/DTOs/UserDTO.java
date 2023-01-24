package com.healtheme.patients.DTOs;


import com.healtheme.patients.Entities.PatientMedsEnt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    Long id;
    String email;
    String firstName;
    String lastName;
    List<PatientMedsEnt> patientMedRecords;

}
