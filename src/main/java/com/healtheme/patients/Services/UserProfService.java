package com.healtheme.patients.Services;

import com.healtheme.patients.DTOs.PatientMedsDTO;
import com.healtheme.patients.DTOs.UserDTO;

public interface UserProfService {
    UserDTO savedProfile(UserDTO userprofile);
    UserDTO getUserByEmail(String emailID);
    UserDTO getUserByID(Long id);
    PatientMedsDTO saveMed(PatientMedsDTO userMed, Long userID);
    PatientMedsDTO updateMed(PatientMedsDTO userMed, Long userID);
}
