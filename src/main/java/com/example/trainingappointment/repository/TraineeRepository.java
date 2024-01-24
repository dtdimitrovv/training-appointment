package com.example.trainingappointment.repository;

import com.example.authorizationValidator.repository.AuthenticationEntityRepository;
import com.example.trainingappointment.entity.Trainee;

public interface TraineeRepository extends AuthenticationEntityRepository<Trainee, Long> {
}
