package com.example.trainingappointment.repository;

import com.example.trainingappointment.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
