package org.hackathon.grup3.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hackathon.grup3.app.utils.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;

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
		//testData.csv
		File file = new File ("testData.csv");
		String data = csvParser.parseFile(file);
		
//		csvParser.parseFile(test);
		
		
		System.out.println("Hola");

		//csvParser.parseFile();
	}
}
