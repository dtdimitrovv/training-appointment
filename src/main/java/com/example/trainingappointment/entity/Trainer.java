package com.example.trainingappointment.entity;

import com.example.authorizationValidator.entity.WithoutPrimaryKeyBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "trainers")
public class Trainer extends WithoutPrimaryKeyBaseEntity {

    private Set<Training> trainings;

    public Trainer() {
    }

    public Trainer(Long id) {
        super(id);
    }

    @OneToMany(mappedBy = "trainer")
    public Set<Training> getTrainings() {
        return trainings;
    }

    public Trainer setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
        return this;
    }
}
