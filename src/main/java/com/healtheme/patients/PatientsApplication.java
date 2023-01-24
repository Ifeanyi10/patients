package com.healtheme.patients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.healtheme.patients"})  // force scan JPA entities
public class PatientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsApplication.class, args);
    }

}
