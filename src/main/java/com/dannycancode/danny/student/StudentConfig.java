package com.dannycancode.danny.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository){
    return args -> {

    };
  }
}
