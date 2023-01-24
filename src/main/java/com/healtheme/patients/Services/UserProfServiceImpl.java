package com.healtheme.patients.Services;


import com.healtheme.patients.DTOs.PatientMedsDTO;
import com.healtheme.patients.DTOs.UserDTO;
import com.healtheme.patients.Entities.PatientMedsEnt;
import com.healtheme.patients.Repos.PatientMedsRep;
import com.healtheme.patients.Repos.UserProfileRep;
import com.healtheme.patients.Entities.UserProfileEnt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfServiceImpl implements UserProfService {
    private final UserProfileRep userProfileRep;
    private final PatientMedsRep patientMedsRep;

    public UserProfServiceImpl(UserProfileRep userProfileRep, PatientMedsRep patientMedsRep) {
        this.userProfileRep = userProfileRep;
        this.patientMedsRep = patientMedsRep;
    }

    @Override
    public UserDTO savedProfile(UserDTO userprofile) {
        try {
            UserProfileEnt saved = userProfileRep.save(DTOtoEntity(userprofile));
            return EntitytoDTO(saved);
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public PatientMedsDTO saveMed(PatientMedsDTO userMed, Long userID) {
        try{
            UserProfileEnt profile = userProfileRep.getReferenceById(userID);
            if(profile != null){
                PatientMedsEnt savedMed = patientMedsRep.save(medDTOtoEntity(userMed));
                List<PatientMedsEnt> meds ;
                if(profile.getPatientMedRecords() != null){
                    meds = profile.getPatientMedRecords();
                }else {
                    meds = new ArrayList<>();
                }
                meds.add(savedMed);
                profile.setPatientMedRecords(meds);
                userProfileRep.save(profile);
                return medEntitytoDTO(savedMed);
            }else {
                return null;
            }

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PatientMedsDTO updateMed(PatientMedsDTO userMed, Long userID) {
        try{
            UserProfileEnt profile = userProfileRep.getReferenceById(userID);

            if(profile != null){

                List<PatientMedsEnt> meds ;
                PatientMedsEnt medRecordByID = null;
                if(profile.getPatientMedRecords() != null){
                    meds = profile.getPatientMedRecords();
                    for(PatientMedsEnt med: meds){
                        if(med.getId().equals(userMed.getId())){
                            medRecordByID = med;
                            break;
                        }
                    }
                    medRecordByID.setMedName(userMed.getMedName());
                    medRecordByID.setDosageUnit(userMed.getDosageUnit());
                    medRecordByID.setDosage(userMed.getDosage());
                    medRecordByID.setNotes(userMed.getNotes());
                    profile.setPatientMedRecords(meds);
                    userProfileRep.save(profile);
                    return medEntitytoDTO(medRecordByID);
                }else {
                    return null;
                }

            }else {
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public UserDTO getUserByEmail(String emailID) {
        try {
            UserProfileEnt profile = userProfileRep.findByemail(emailID);
            if(profile != null){
                return EntitytoDTO(profile);
            }else{
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserDTO getUserByID(Long id) {
        try {
            // retrieve profile to update user Level
            UserProfileEnt savedProfile = userProfileRep.getReferenceById(id);
            if(savedProfile != null){
                UserProfileEnt profile = userProfileRep.findByid(id);
                if(profile != null){
                    return EntitytoDTO(profile);
                }
                else{
                    return null;
                }
            }else{
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }


    UserProfileEnt DTOtoEntity(UserDTO userprofile){
        UserProfileEnt entity = new UserProfileEnt();
        entity.setFirstName(userprofile.getFirstName());
        entity.setLastName(userprofile.getLastName());
        entity.setEmail(userprofile.getEmail());
        entity.setPatientMedRecords(userprofile.getPatientMedRecords());
        entity.setId(userprofile.getId());
        return entity;
    }

    UserDTO EntitytoDTO(UserProfileEnt userprofile){
        UserDTO dto = new UserDTO();
        dto.setFirstName(userprofile.getFirstName());
        dto.setLastName(userprofile.getLastName());
        dto.setEmail(userprofile.getEmail());
        dto.setPatientMedRecords(userprofile.getPatientMedRecords());
        dto.setId(userprofile.getId());
        return dto;
    }

    PatientMedsEnt medDTOtoEntity(PatientMedsDTO usermed){
        PatientMedsEnt entity = new PatientMedsEnt();
        entity.setId(usermed.getId());
        entity.setMedName(usermed.getMedName());
        entity.setDosageUnit(usermed.getDosageUnit());
        entity.setDosage(usermed.getDosage());
        entity.setNotes(usermed.getNotes());
        return entity;
    }

    PatientMedsDTO medEntitytoDTO(PatientMedsEnt usermed){
        PatientMedsDTO dto = new PatientMedsDTO();
        dto.setId(usermed.getId());
        dto.setMedName(usermed.getMedName());
        dto.setDosageUnit(usermed.getDosageUnit());
        dto.setDosage(usermed.getDosage());
        dto.setNotes(usermed.getNotes());
        return dto;
    }

}

