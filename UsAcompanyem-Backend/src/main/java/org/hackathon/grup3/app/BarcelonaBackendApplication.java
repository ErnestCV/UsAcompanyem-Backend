package org.hackathon.grup3.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BarcelonaBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BarcelonaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//TODO -> leer CSVs y pasar a JSON y guardar en BD (en bucle, 73)
		System.out.println("Hola");
	}
}
