package org.hackathon.grup3.app.service;

import org.hackathon.grup3.app.model.Barrio;
import org.hackathon.grup3.app.model.DistricteBarri;
import org.hackathon.grup3.app.model.MediaBarrios;
import org.hackathon.grup3.app.repository.DataRepository;
import org.hackathon.grup3.app.repository.DistricteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private DistricteRepository districteRepository;

    public List<Barrio> getBarrios() {

        return dataRepository.findAll();
    }

    public MediaBarrios getAverage() {

        double mediaPobreza1 = getBarrios().stream().mapToDouble(Barrio::getIndicePobreza).average().orElse(0d);
        return new MediaBarrios(mediaPobreza1, 25.7, 21.1);
    }

    public List<DistricteBarri> getDistricts() {

        return districteRepository.findAll();
    }
}
