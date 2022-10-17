package org.hackathon.grup3.app;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hackathon.grup3.app.model.Barrio;
import org.hackathon.grup3.app.repository.DataRepository;
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

	@Autowired
	private DataRepository dataRepository;

	public static void main(String[] args) {
		SpringApplication.run(BarcelonaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		File file = new File(BarcelonaBackendApplication.class.getClassLoader().getResource("data.csv").getFile());
		List<Barrio> data = csvParser.parseFile(file);

		data.forEach(barrio -> {
			try {
				barrio.addCords();
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			dataRepository.save(barrio);
		});
	}
}
