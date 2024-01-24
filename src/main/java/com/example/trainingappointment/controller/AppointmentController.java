package com.example.trainingappointment.controller;

import com.example.authorizationValidator.config.argumentResolver.AuthenticatedPrincipal;
import com.example.authorizationValidator.security.IsAuthenticated;
import com.example.trainingappointment.entity.Trainee;
import com.example.trainingappointment.payload.request.AppointmentRequest;
import com.example.trainingappointment.service.appointment.AppointmentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/{trainerId}")
    @IsAuthenticated
    public void appoint(
            @PathVariable Long trainerId,
            @RequestBody AppointmentRequest appointmentRequest,
            @AuthenticatedPrincipal Trainee trainee
    ) {
        this.appointmentService
                .appoint(
                        trainee,
                        trainerId,
                        appointmentRequest
                );
    }
}
