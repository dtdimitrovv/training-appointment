package com.example.trainingappointment.repository;

import com.example.trainingappointment.entity.Trainer;
import com.example.trainingappointment.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    int countByStartTimeAndTrainer(LocalDateTime startTime, Trainer trainer);
}
