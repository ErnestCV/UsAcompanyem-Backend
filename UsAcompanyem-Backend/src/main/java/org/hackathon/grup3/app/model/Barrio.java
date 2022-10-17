package org.hackathon.grup3.app.model;

import com.google.gson.Gson;
import lombok.*;
import org.hackathon.grup3.app.model.coords.BarriCoords;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Barrio {
    private String id;
    private String nombre;
    private double indicePobreza;
    private double mayor65;
    private double soledad65;
    private double lat;
    private double lon;


    private void addCords( ){
        HttpRequest getCoordsRequest = HttpRequest.newBuilder()
                .uri(new URI("https://w33.bcn.cat/geoBCN/serveis/territori/barris/01"))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(getCoordsRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        BarriCoords barriCoords = gson.fromJson(postResponse.body(), BarriCoords.class);
    }





}
