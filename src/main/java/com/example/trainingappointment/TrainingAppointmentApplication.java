package com.example.trainingappointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TrainingAppointmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingAppointmentApplication.class,
                args);
    }

}
