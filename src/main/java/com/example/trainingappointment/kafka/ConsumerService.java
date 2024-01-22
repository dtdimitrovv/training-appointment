package com.example.trainingappointment.kafka;

import com.example.trainingappointment.entity.Trainee;
import com.example.trainingappointment.entity.Trainer;
import com.example.trainingappointment.repository.TraineeRepository;
import com.example.trainingappointment.repository.TrainerRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {
    private final TrainerRepository trainerRepository;
    private final TraineeRepository traineeRepository;

    public ConsumerService(
            TrainerRepository trainerRepository,
            TraineeRepository traineeRepository
    ) {
        this.trainerRepository = trainerRepository;
        this.traineeRepository = traineeRepository;
    }

    @KafkaListener(topics = "UserCreated", groupId = "groupId")
    public void createUser(@Header("User-Id") String userId, @Header("User-Type") String userType) {
        if (userType.equals("TRAINER")) {
            this.trainerRepository.save(new Trainer(Long.parseLong(userId)));
        } else {
            this.traineeRepository.save(new Trainee(Long.parseLong(userId)));
        }
    }
}
