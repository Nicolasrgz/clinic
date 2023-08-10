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
			//one to one
			Patient patient = new Patient("nicolas", "gonzalez", 44994133, "klasdjds");
			patientRepository.save(patient);
			ClinicHistory clinicHistory = new ClinicHistory(patient.getLastName() + " " + patient.getName(), LocalDate.now(), "doctor pepe", "cancer","se puede curar");
			patient.addClinicHistory(clinicHistory);
			clinicHistoryRepository.save(clinicHistory);

			//many to many
			Medic drPepe = new Medic("pepe", "gomez", 40, "453-567-2");
			Medic drJose = new Medic("jose", "perez", 40, "453-567-2");
			Medic drJake = new Medic("jake", "gonzalez", 40, "453-567-2");
			Medic drKeo = new Medic("keo", "kidd", 40, "453-567-2");
			medicRepository.save(drPepe);
			medicRepository.save(drJose);
			medicRepository.save(drJake);
			medicRepository.save(drKeo);

			MedicalSpecialties cardiology = new MedicalSpecialties("cardiology", "A");
			MedicalSpecialties kinesiologist = new MedicalSpecialties("kinesiologist", "B");
			drPepe.addMedicalSpecialty(cardiology);
			drJose.addMedicalSpecialty(cardiology);
			drJake.addMedicalSpecialty(cardiology);
			drKeo.addMedicalSpecialty(cardiology);

			drPepe.addMedicalSpecialty(kinesiologist);
			drJose.addMedicalSpecialty(kinesiologist);

			cardiology.addMedic(drPepe);
			cardiology.addMedic(drJake);
			cardiology.addMedic(drJose);
			cardiology.addMedic(drKeo);

			cardiology.addMedic(drPepe);
			cardiology.addMedic(drJose);

			medicalSpecialtiesRepository.save(cardiology);
			medicalSpecialtiesRepository.save(kinesiologist);

			medicRepository.save(drPepe);
			medicRepository.save(drJose);
			medicRepository.save(drJake);
			medicRepository.save(drKeo);
		};
	}

}
