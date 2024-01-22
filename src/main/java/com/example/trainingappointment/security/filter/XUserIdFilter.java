package com.example.trainingappointment.security.filter;

import com.example.trainingappointment.exception.InvalidUserIdException;
import com.example.trainingappointment.repository.TraineeRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class XUserIdFilter extends BasicAuthenticationFilter {

    private final TraineeRepository traineeRepository;

    public XUserIdFilter(AuthenticationManager authenticationManager, TraineeRepository traineeRepository) {
        super(authenticationManager);
        this.traineeRepository = traineeRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        var traineeId = request.getHeader("X-User-Id");

        if (traineeId == null) {
            chain.doFilter(request, response);
        }

        this.traineeRepository
                .findById(Long.parseLong(Objects.requireNonNull(traineeId)))
                .ifPresentOrElse(trainee -> SecurityContextHolder
                        .getContext()
                        .setAuthentication(
                                new UsernamePasswordAuthenticationToken(trainee,
                                        null,
                                        new ArrayList<>()
                                )
                        ), () -> {
                    throw new InvalidUserIdException();
                });

        chain.doFilter(request, response);
    }
}
