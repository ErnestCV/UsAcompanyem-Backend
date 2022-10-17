package org.hackathon.grup3.app;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.hackathon.grup3.app.model.Barrio;
import org.hackathon.grup3.app.model.DistricteBarri;
import org.hackathon.grup3.app.repository.DataRepository;
import org.hackathon.grup3.app.repository.DistricteRepository;
import org.hackathon.grup3.app.utils.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BarcelonaBackendApplication implements CommandLineRunner {

	@Autowired
	private CSVParser csvParser;

	@Autowired
	private DataRepository dataRepository;

	@Autowired
	private DistricteRepository districteRepository;

	public static void main(String[] args) {
		SpringApplication.run(BarcelonaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		File file = new File(BarcelonaBackendApplication.class.getClassLoader().getResource("data.csv").getFile());
		List<Barrio> data = csvParser.parseFileBarrio(file);

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

		File file1 = new File(BarcelonaBackendApplication.class.getClassLoader().getResource("districtes.csv").getFile());
		List<DistricteBarri> districtes = csvParser.parseFileDistricte(file1);

		districtes.forEach(districteBarri -> districteRepository.save(districteBarri));

	}
}
