package com.example.trainingappointment.payload.request;

import java.time.LocalDateTime;

public record AppointmentRequest(LocalDateTime startHour) {
}
