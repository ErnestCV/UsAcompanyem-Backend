package org.hackathon.grup3.app;

import org.hackathon.grup3.app.utils.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BarcelonaBackendApplication implements CommandLineRunner {

	@Autowired
	private CSVParser csvParser;

	public static void main(String[] args) {
		SpringApplication.run(BarcelonaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//TODO -> leer CSVs y pasar a JSON y guardar en BD
		System.out.println("Hola");

		//csvParser.parseFile();
	}
}
