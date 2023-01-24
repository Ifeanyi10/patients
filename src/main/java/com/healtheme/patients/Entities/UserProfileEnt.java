package com.healtheme.patients.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileEnt extends BaseEnt {
    String email;
    String firstName;
    String lastName;
    @OneToMany
    List<PatientMedsEnt> patientMedRecords;
}
