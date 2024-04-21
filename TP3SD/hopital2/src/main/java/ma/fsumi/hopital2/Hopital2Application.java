package ma.fsumi.hopital2;

import ma.fsumi.hopital2.entities.Patient;
import ma.fsumi.hopital2.repository.Patientrespositoty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class Hopital2Application implements CommandLineRunner {
	private final Patientrespositoty patientrespositoty;

	public Hopital2Application(Patientrespositoty patientrespositoty) {
		this.patientrespositoty = patientrespositoty;
	}


	public static void main(String[] args) {
		SpringApplication.run(Hopital2Application.class, args);
	}

	@Override
	public void run(String... args) {
		Patient patient = new Patient();
		patient.setId(null);
		patient.setNom("Ahmed");
		patient.setDateNaissace(new Date());
		patient.setMalade(false);
		patient.setScore(20);

		Patient patient2 = new Patient(null , "Rachid" , new Date() , false , 14);


		Patient patient3=Patient.builder()
				.nom("Yassmine")
				.dateNaissace(new Date())
				.score(33)
				.malade(true)
				.build();

		patientrespositoty.save(patient);
		patientrespositoty.save(patient2);
		patientrespositoty.save(patient3);



	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
