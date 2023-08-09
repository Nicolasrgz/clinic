package com.dev.clinic;

import com.dev.clinic.models.Patient;
import com.dev.clinic.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(PatientRepository patientRepository) {
		return args -> {
			Patient patient = new Patient("nicolas", "gonzalez", 44994133, "klasdjds");
			patientRepository.save(patient);
		};
	}

}
