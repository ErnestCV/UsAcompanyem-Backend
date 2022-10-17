package org.hackathon.grup3.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @PostMapping
    public void postNewData() {

    }

    @GetMapping("/barris")
    public void getNeighbourhoodData() {

    }

    @GetMapping("/average")
    public void getAverage() {

    }

    @GetMapping("/districtes")
    public void getDistricts() {

    }

}
