package com.example.trainingappointment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainees")
public class Trainee extends BaseEntity {
    public Trainee() {
    }

    public Trainee(Long id) {
        super(id);
    }
}
