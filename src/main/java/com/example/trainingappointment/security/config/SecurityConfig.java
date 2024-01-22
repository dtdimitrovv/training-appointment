package com.example.trainingappointment.security.config;

import com.example.trainingappointment.repository.TraineeRepository;
import com.example.trainingappointment.security.filter.XUserIdFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final SecurityBeanConfig securityBeanConfig;
    private final TraineeRepository traineeRepository;

    public SecurityConfig(SecurityBeanConfig securityBeanConfig, TraineeRepository traineeRepository) {
        this.securityBeanConfig = securityBeanConfig;
        this.traineeRepository = traineeRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws
            Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll()
                .and()
                .addFilter(new XUserIdFilter(this.securityBeanConfig.authenticationManager(http), this.traineeRepository));

        return http.build();
    }
}
