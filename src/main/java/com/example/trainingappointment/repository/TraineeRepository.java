package com.example.trainingappointment.repository;

import com.example.trainingappointment.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
}
