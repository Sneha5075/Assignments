package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository)
	{
		return args->{
			Student sneha=new Student("sneha","sneha@gmail.com",LocalDate.of(2000,3,3));
			Student gudly=new Student("gudly","gudly@gmail.com",LocalDate.of(1995,2,3));
			
			repository.saveAll(List.of(sneha,gudly));
		};
	}

}
