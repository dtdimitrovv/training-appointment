package com.example.trainingappointment.service.userCreation;

import com.example.trainingappointment.entity.Trainee;
import com.example.trainingappointment.repository.TraineeRepository;
import org.springframework.stereotype.Component;

import static com.example.trainingappointment.constant.UserTypeConstant.TRAINEE_USER_TYPE;

@Component(TRAINEE_USER_TYPE)
public class TraineeCreationServiceImpl implements UserCreationService {

    private final TraineeRepository traineeRepository;

    public TraineeCreationServiceImpl(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    @Override
    public void create(Long id) {
        this.traineeRepository.save(new Trainee(id));
    }
}
