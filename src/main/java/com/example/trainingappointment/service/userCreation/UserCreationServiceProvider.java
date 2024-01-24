package com.example.trainingappointment.service.userCreation;

import com.example.trainingappointment.exception.InvalidUserTypeException;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class UserCreationServiceProvider {

    private final Map<String, UserCreationService> userCreationServices;

    public UserCreationServiceProvider(Map<String, UserCreationService> userCreationServices) {
        this.userCreationServices = userCreationServices;
    }

    public UserCreationService getByUserType(String userType) {
        return Optional.ofNullable(this.userCreationServices.get(userType))
                .orElseThrow(InvalidUserTypeException::new);
    }
}
