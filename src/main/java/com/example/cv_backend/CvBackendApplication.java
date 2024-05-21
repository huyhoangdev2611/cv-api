package com.example.cv_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.cv_backend.repository")
public class CvBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvBackendApplication.class, args);
    }
}
