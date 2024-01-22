package com.example.trainingappointment.controller;

import com.example.trainingappointment.entity.Trainee;
import com.example.trainingappointment.payload.request.AppointmentRequest;
import com.example.trainingappointment.service.AppointmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @PreAuthorize("isAuthenticated()")
    public void appoint(
            @PathVariable Long trainerId,
            @RequestBody     AppointmentRequest appointmentRequest,
            @AuthenticationPrincipal Trainee trainee
    ) {
        this.appointmentService
                .appoint(
                        trainee,
                        trainerId,
                        appointmentRequest
                );
    }
}
