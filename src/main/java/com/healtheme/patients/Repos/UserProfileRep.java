package com.healtheme.patients.Repos;

import com.healtheme.patients.Entities.UserProfileEnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRep extends JpaRepository<UserProfileEnt, Long> {
    UserProfileEnt findByemail(String useremail);
    UserProfileEnt findByid(Long id);
}

