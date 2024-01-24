package com.example.trainingappointment.service.userCreation;

import com.example.trainingappointment.entity.Trainer;
import com.example.trainingappointment.repository.TrainerRepository;
import org.springframework.stereotype.Component;

import static com.example.trainingappointment.constant.UserTypeConstant.TRAINER_USER_TYPE;

@Component(TRAINER_USER_TYPE)
public class TrainerCreationServiceImpl implements UserCreationService {

    private final TrainerRepository trainerRepository;

    public TrainerCreationServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public void create(Long id) {
        this.trainerRepository.save(new Trainer(id));
    }
}
