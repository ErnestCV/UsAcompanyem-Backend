package org.hackathon.grup3.app.controller;

import org.hackathon.grup3.app.model.Barrio;
import org.hackathon.grup3.app.model.DistricteBarri;
import org.hackathon.grup3.app.model.MediaBarrios;
import org.hackathon.grup3.app.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

//    @PostMapping
//    public void postNewData() {
//
//    }

    @GetMapping("/barris")
    public List<Barrio> getNeighbourhoodData() {

        return dataService.getBarrios();
    }

    @GetMapping("/average")
    public MediaBarrios getAverage() {

        return dataService.getAverage();
    }

    @GetMapping("/districtes")
    public List<DistricteBarri> getDistricts() {

        return dataService.getDistricts();
    }
}
