package com.example.agrichaint_pm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableTransactionManagement
public class TransactionConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}