package com.example.trainingappointment.service.appointment;

import com.example.trainingappointment.entity.Trainee;
import com.example.trainingappointment.payload.request.AppointmentRequest;

public interface AppointmentService {
    void appoint(Trainee trainee, Long trainerId, AppointmentRequest appointmentRequest);
}
