package org.hackathon.grup3.app.controller;

import org.hackathon.grup3.app.model.Barrio;
import org.hackathon.grup3.app.model.MediaBarrios;
import org.hackathon.grup3.app.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
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
    public List<Barrio> getNeighbourhoodData() throws IOException, InterruptedException, URISyntaxException {

        return dataService.getBarrios();
    }

    @GetMapping("/average")
    public MediaBarrios getAverage() {
        double mediaPobreza1 = dataService.getBarrios().stream().mapToDouble(Barrio::getIndicePobreza).average().orElse(0d);
      return new MediaBarrios(mediaPobreza1,25.7, 21.1);
        //indice de pobreza, %65, % gente sola
    }

    @GetMapping("/districtes")
    public void getDistricts() {

    }

}
