package org.example.jpamovie.week10_jpaproject;
import java.time.LocalDateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class Week10JpaprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week10JpaprojectApplication.class, args);
    }

}
