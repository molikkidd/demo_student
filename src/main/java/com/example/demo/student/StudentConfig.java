package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.AUGUST;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRespository respository) {
        return  args -> {
           Student mariam =  new Student(
                    "Mariam",
                    "mzgm@fake.com",
                    LocalDate.of(2000, AUGUST, 11)
            );
           Student alex =  new Student(
                   "Alex",
                   "alex_xela@fake.com",
                   LocalDate.of(2004, AUGUST, 11)
           );
            Student mo =  new Student(
                    "Mo",
                    "mokkkz@fake.com",
                    LocalDate.of(2000, AUGUST, 9)
            );

           respository.saveAll(
                   List.of(mariam,alex,mo)
           );
        };
    }
}
