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

        //TODO: leer de API https://w33.bcn.cat/geoBCN/doc/rest/API.aspx#Barris, en bucle, y 1) parsear a json, 2) añadir coords
    }

    @GetMapping("/average")
    public void getAverage() {

    }

    @GetMapping("/districtes")
    public void getDistricts() {

    }

}
