package com.dev.clinic;

import com.dev.clinic.models.*;
import com.dev.clinic.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
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
	public CommandLineRunner initData(PatientRepository patientRepository, ClinicHistoryRepository clinicHistoryRepository, MedicRepository medicRepository, MedicalSpecialtiesRepository medicalSpecialtiesRepository, MedicalAppointmentsRepository medicalAppointmentsRepository,
									  PrescriptionRepository prescriptionRepository) {
		return args -> {
			//one to one
			Patient patient = new Patient("nicolas", "gonzalez", 44994130, 20, "nicolas@gmail.com", "1234");
			Patient patient2 = new Patient("alejandro", "franco", 43994131, 21, "ale@gmail.com", "1234");
			Patient patient3 = new Patient("juan", "galarza", 45994132, 19, "juan@gmail.com", "1234");
			patientRepository.save(patient);
			patientRepository.save(patient2);
			patientRepository.save(patient3);

			ClinicHistory clinicHistory = new ClinicHistory(patient.getLastName() + " " + patient.getName(), LocalDate.now(), "doctor pepe", "cancer","se puede curar", 44994133);
			ClinicHistory clinicHistoryAle = new ClinicHistory(patient2.getLastName() + " " + patient2.getName(), LocalDate.now(), "doctor pepe", "pelado","no se puede curar",43994133);
			ClinicHistory clinicHistoryJuan = new ClinicHistory(patient3.getLastName() + " " + patient3.getName(), LocalDate.now(), "doctor pepe", "perro","no se puede curar", 45994133);
			patient.addClinicHistory(clinicHistory);
			patient2.addClinicHistory(clinicHistoryAle);
			patient3.addClinicHistory(clinicHistoryJuan);

			clinicHistoryRepository.save(clinicHistory);
			clinicHistoryRepository.save(clinicHistoryAle);
			clinicHistoryRepository.save(clinicHistoryJuan);

			//many to many
			Medic drPepe = new Medic("pepe", "gomez", 40, "pepe@gmail.com", "453-567-0", "1234");
			Medic drJose = new Medic("jose", "perez", 40, "jose@gmail.com", "453-567-1", "1234");
			Medic drJake = new Medic("jake", "gonzalez", 40, "jake@gmail.com", "453-567-2", "1234");
			Medic drKeo = new Medic("keo", "kidd", 40, "keo@gmail.com", "453-567-3", "1234");

			MedicalSpecialties cardiology = new MedicalSpecialties("cardiology", "A");
			MedicalSpecialties kinesiologist = new MedicalSpecialties("kinesiologist", "B");
			MedicalSpecialties pediatrician = new MedicalSpecialties("pediatrician", "C");
			MedicalSpecialties urologist = new MedicalSpecialties("urologist", "D");

			medicRepository.save(drPepe);
			medicRepository.save(drJose);
			medicRepository.save(drJake);
			medicRepository.save(drKeo);

			drPepe.addMedicalSpecialty(cardiology);
			drPepe.addMedicalSpecialty(pediatrician);
			drPepe.addMedicalSpecialty(kinesiologist);
			drJose.addMedicalSpecialty(cardiology);
			drJose.addMedicalSpecialty(kinesiologist);
			drKeo.addMedicalSpecialty(cardiology);
			drKeo.addMedicalSpecialty(kinesiologist);
			drKeo.addMedicalSpecialty(urologist);
			drJake.addMedicalSpecialty(cardiology);


			cardiology.addMedic(drPepe);
			cardiology.addMedic(drJake);
			cardiology.addMedic(drJose);
			cardiology.addMedic(drKeo);

			kinesiologist.addMedic(drPepe);
			kinesiologist.addMedic(drJose);
			kinesiologist.addMedic(drKeo);

			urologist.addMedic(drKeo);
			pediatrician.addMedic(drPepe);

			MedicalAppointments revision1 = new MedicalAppointments(LocalDate.now(), "revision");
			MedicalAppointments revision2 = new MedicalAppointments(LocalDate.now(), "revision");
			MedicalAppointments revision3 = new MedicalAppointments(LocalDate.now(), "revision");

			drJake.addMedicalAppointment(revision1);
			clinicHistory.addMedicalAppointments(revision1);

			drPepe.addMedicalAppointment(revision2);
			clinicHistory.addMedicalAppointments(revision2);

			drJose.addMedicalAppointment(revision3);
			clinicHistory.addMedicalAppointments(revision3);

			Prescription prescription = new Prescription(drPepe.getLastName() +" " + drPepe.getName(), patient.getName() +" "+ patient.getLastName(), drPepe.getRegistrationNumber(), "ibuprofeno");
			drPepe.addPrescription(prescription);
			clinicHistory.addPrescription(prescription);

			prescriptionRepository.save(prescription);

			medicalAppointmentsRepository.save(revision1);
			medicalAppointmentsRepository.save(revision2);
			medicalAppointmentsRepository.save(revision3);

			medicalSpecialtiesRepository.save(cardiology);
			medicalSpecialtiesRepository.save(kinesiologist);
			medicalSpecialtiesRepository.save(pediatrician);
			medicalSpecialtiesRepository.save(urologist);

			medicRepository.save(drPepe);
			medicRepository.save(drJose);
			medicRepository.save(drJake);
			medicRepository.save(drKeo);


		};
	}

}
