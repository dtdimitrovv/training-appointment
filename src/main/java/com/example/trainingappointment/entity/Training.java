package com.example.trainingappointment.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "trainings")
public class Training  { // TODO - could be renamed to appointment
    private Long id;
    private Trainer trainer;
    private Trainee trainee;
    private LocalDateTime startTime;

    public Training() {
    }

    public Training(Trainer trainer, Trainee trainee, LocalDateTime startTime) {
        this.trainer = trainer;
        this.trainee = trainee;
        this.startTime = startTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public Training setId(Long id) {
        this.id = id;
        return this;
    }

    @ManyToOne
    @JoinColumn(unique = true)
    public Trainer getTrainer() {
        return trainer;
    }

    public Training setTrainer(Trainer trainer) {
        this.trainer = trainer;
        return this;
    }

    @ManyToOne
    @JoinColumn(unique = true)
    public Trainee getTrainee() {
        return trainee;
    }

    public Training setTrainee(Trainee trainee) {
        this.trainee = trainee;
        return this;
    }

    @Column(unique = true)
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Training setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }
}
