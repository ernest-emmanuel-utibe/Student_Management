package com.real.student.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    public ActiveUserStore activeUserStore() {
        return new ActiveUserStore();
    }
}
