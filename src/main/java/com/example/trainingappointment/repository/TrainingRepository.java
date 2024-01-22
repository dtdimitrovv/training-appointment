package com.example.trainingappointment.repository;

import com.example.trainingappointment.entity.Trainee;
import com.example.trainingappointment.entity.Trainer;
import com.example.trainingappointment.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TrainingRepository extends JpaRepository<Training,Long> {
    int countByStartTimeAndTrainer(LocalDateTime startTime, Trainer trainer);

    boolean existsByStartTimeAndTraineeAndTrainer(LocalDateTime startTime, Trainee trainee, Trainer trainer);
}
