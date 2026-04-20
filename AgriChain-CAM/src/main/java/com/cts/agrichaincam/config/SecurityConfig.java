package com.cts.agrichaincam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for H2 console and API endpoints
            .csrf(csrf -> csrf
                .ignoringRequestMatchers(
                    "/h2-console/**",
                    "/api/**"
                )
            )
            // Allow H2 console frames
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.disable())
            )
            // Configure authorization
            .authorizeHttpRequests(authz -> authz
                // Allow H2 console without authentication
                .requestMatchers("/h2-console/**").permitAll()
                // Allow API endpoints
                .requestMatchers("/api/**").permitAll()
                // Allow home and health endpoints
                .requestMatchers("/").permitAll()
                .requestMatchers("/health").permitAll()
                // All other requests require authentication
                .anyRequest().authenticated()
            )
            .httpBasic(basic -> {});

        return http.build();
    }
}


