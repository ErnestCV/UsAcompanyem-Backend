package org.hackathon.grup3.app.service;

import org.hackathon.grup3.app.model.Barrio;
import org.hackathon.grup3.app.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    public List<Barrio> getBarrios() {

        return dataRepository.findAll();
    }
}
