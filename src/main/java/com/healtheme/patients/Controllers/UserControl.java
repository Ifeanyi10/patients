package com.healtheme.patients.Controllers;

import com.healtheme.patients.DTOs.PatientMedsDTO;
import com.healtheme.patients.DTOs.UserDTO;
import com.healtheme.patients.Services.AuthService;
import com.healtheme.patients.Services.UserProfService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/")
@CrossOrigin
public class UserControl {

    final UserProfService userProfService;
    private final AuthService authService;

    public UserControl(UserProfService userProfService, AuthService authService) {
        this.userProfService = userProfService;
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity<String> start(){
        return new ResponseEntity<>("Patient App have started", HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Validated UserDTO userDTO ){
        UserDTO saved = userProfService.savedProfile(userDTO);
        if(saved != null){
            return new ResponseEntity<>(saved, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<UserDTO> login(HttpServletRequest request){
        UserDTO saved = userProfService.getUserByEmail(authService.getIdentifier(request));
        if(saved != null){
            return new ResponseEntity<>(saved, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }


    @PostMapping("/userprofile/{id}")
    public ResponseEntity<UserDTO> getUserProfileByID(@PathVariable("id") long id){
        UserDTO saved = userProfService.getUserByID(id);
        if(saved != null){
            return new ResponseEntity<>(saved, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @PostMapping("/updatemed/{id}")
    public ResponseEntity<PatientMedsDTO> update(@PathVariable("id") long id,
                                                    @RequestBody @Validated PatientMedsDTO patientMedsDTO){
        PatientMedsDTO saved = userProfService.updateMed(patientMedsDTO, id);
        if(saved != null){
            return new ResponseEntity<>(saved, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @PostMapping("/savemed/{id}")
    public ResponseEntity<PatientMedsDTO> saveMed(@PathVariable("id") long id,
                                                    @RequestBody @Validated PatientMedsDTO patientMedsDTO){
        PatientMedsDTO saved = userProfService.saveMed(patientMedsDTO, id);
        if(saved != null){
            return new ResponseEntity<>(saved, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
