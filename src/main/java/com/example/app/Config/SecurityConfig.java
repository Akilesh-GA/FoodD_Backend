package com.example.app.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF (only for development/testing)
            .csrf(csrf -> csrf.disable())

            // Allow H2 Console to be displayed in frames
            .headers(headers ->
                headers.frameOptions(frame -> frame.disable())
            )

            // Allow every request without authentication
            .authorizeHttpRequests(auth ->
                auth.anyRequest().permitAll()
            );

        return http.build();
    }
}