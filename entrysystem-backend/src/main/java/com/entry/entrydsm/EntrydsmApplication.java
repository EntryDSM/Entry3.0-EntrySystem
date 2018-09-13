package com.entry.entrydsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EntrydsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntrydsmApplication.class, args);
    }
}
