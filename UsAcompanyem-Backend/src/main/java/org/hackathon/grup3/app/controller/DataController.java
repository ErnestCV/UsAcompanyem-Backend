package org.hackathon.grup3.app.controller;

import com.google.gson.Gson;
import org.hackathon.grup3.app.model.coords.BarriCoords;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @PostMapping
    public void postNewData() {

    }

    @GetMapping("/barris")
    public void getNeighbourhoodData() throws IOException, InterruptedException, URISyntaxException {

        //TODO: leer de API https://w33.bcn.cat/geoBCN/doc/rest/API.aspx#Barris, en bucle, y 1) parsear a json, 2) añadir coords

        HttpRequest getCoordsRequest = HttpRequest.newBuilder()
                .uri(new URI("https://w33.bcn.cat/geoBCN/serveis/territori/barris/01"))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(getCoordsRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(postResponse.body());

        Gson gson = new Gson();
        BarriCoords barriCoords = gson.fromJson(postResponse.body(), BarriCoords.class);

        System.out.println(barriCoords.getResultats().get(0).getLocalitzacio().getX());
    }

    @GetMapping("/average")
    public void getAverage() {

    }

    @GetMapping("/districtes")
    public void getDistricts() {

    }

}
