package com.dev.clinic;

import com.dev.clinic.models.ClinicHistory;
import com.dev.clinic.models.Medic;
import com.dev.clinic.models.MedicalSpecialties;
import com.dev.clinic.models.Patient;
import com.dev.clinic.repositories.ClinicHistoryRepository;
import com.dev.clinic.repositories.MedicRepository;
import com.dev.clinic.repositories.MedicalSpecialtiesRepository;
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
	public CommandLineRunner initData(PatientRepository patientRepository, ClinicHistoryRepository clinicHistoryRepository, MedicRepository medicRepository, MedicalSpecialtiesRepository medicalSpecialtiesRepository) {
		return args -> {
			//relation one to one patient wicht clinicHistory
			Patient patient = new Patient("nicolas", "gonzalez", 44994133, "klasdjds");
			patientRepository.save(patient);
			ClinicHistory clinicHistory = new ClinicHistory(patient.getLastName() + " " + patient.getName(), LocalDate.now(), "doctor pepe", "cancer","se puede curar");
			patient.addClinicHistory(clinicHistory);
			clinicHistoryRepository.save(clinicHistory);

			Medic drPepe = new Medic("pepe", "gomez", 40, "453-567-2");
			medicRepository.save(drPepe);
			MedicalSpecialties cardiology = new MedicalSpecialties("cardiology", "A ");
			drPepe.addMedicalSpecialty(cardiology);
			medicalSpecialtiesRepository.save(cardiology);
		};
	}

}
