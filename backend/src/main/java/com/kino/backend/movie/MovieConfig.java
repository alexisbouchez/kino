package com.kino.backend.movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository repository) {
        return args -> {
            Movie johnWick = new Movie(1L, "John Wick", "Action", 2014);

            repository.save(johnWick);
        };
    }
}
