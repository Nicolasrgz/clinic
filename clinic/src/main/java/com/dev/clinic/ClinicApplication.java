package com.dev.clinic;

import com.dev.clinic.models.ClinicHistory;
import com.dev.clinic.models.Patient;
import com.dev.clinic.repositories.ClinicHistoryRepository;
import com.dev.clinic.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(PatientRepository patientRepository, ClinicHistoryRepository clinicHistoryRepository) {
		return args -> {
			Patient patient = new Patient("nicolas", "gonzalez", 44994133, "klasdjds");
			patientRepository.save(patient);
			ClinicHistory clinicHistory = new ClinicHistory(patient.getLastName() + " " + patient.getName(), LocalDate.now(), "doctor pepe", "cancer","se puede curar");
			patient.addClinicHistory(clinicHistory);
			clinicHistoryRepository.save(clinicHistory);
		};
	}

}
