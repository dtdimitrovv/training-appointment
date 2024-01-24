package com.example.trainingappointment.service.appointment;

import com.example.trainingappointment.entity.Trainee;
import com.example.trainingappointment.entity.Training;
import com.example.trainingappointment.exception.NoEmptyTrainerSlotsException;
import com.example.trainingappointment.exception.NonExistingTrainerIdException;
import com.example.trainingappointment.exception.TrainingAlreadyAppointedException;
import com.example.trainingappointment.payload.request.AppointmentRequest;
import com.example.trainingappointment.repository.TrainerRepository;
import com.example.trainingappointment.repository.TrainingRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final TrainerRepository trainerRepository;
    private final TrainingRepository trainingRepository;

    public AppointmentServiceImpl(
            TrainerRepository trainerRepository,
            TrainingRepository trainingRepository
    ) {
        this.trainerRepository = trainerRepository;
        this.trainingRepository = trainingRepository;
    }

    @Override
    public void appoint(Trainee trainee, Long trainerId, AppointmentRequest appointmentRequest) {
        this.trainerRepository
                .findById(trainerId)
                    .ifPresentOrElse(trainer -> {
                            var startHour = appointmentRequest.startHour().truncatedTo(ChronoUnit.HOURS);
                            if (this.trainingRepository.countByStartTimeAndTrainer(startHour, trainer) < 3) {
                                try {
                                    this.trainingRepository.save(new Training(trainer, trainee, startHour));
                                } catch (DataIntegrityViolationException e) {
                                    throw new TrainingAlreadyAppointedException();
                                }
                            } else {
                                throw new NoEmptyTrainerSlotsException();
                            }
                        },
                        () -> {
                            throw new NonExistingTrainerIdException();
                        });
    }
}
