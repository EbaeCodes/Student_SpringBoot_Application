package com.example.studentSpring.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
     CommandLineRunner commandLineRunner(StudentRepository studentRepository){
         return args -> {
              Student Ebere =  new Student(
                     "Ebere",
                     "ebere@gmail.com",
                     LocalDate.of(1996, Month.JANUARY, 5)
             );

             Student Eric =  new Student(
                     "Eric",
                     "eric@gmail.com",
                     LocalDate.of(1987, Month.JANUARY, 5)
             );

             studentRepository.saveAll(
                     List.of(Ebere,Eric)
             );
         };
     }
}

