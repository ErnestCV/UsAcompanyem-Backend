package org.hackathon.grup3.app.model;

import com.google.gson.Gson;
import lombok.*;
import org.hackathon.grup3.app.model.coords.BarriCoords;
import org.hackathon.grup3.app.utils.CoordParser;
import org.hackathon.grup3.app.utils.LatLng;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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

    @Autowired
    private CoordParser coordParser;


    public void addCords() throws URISyntaxException, IOException, InterruptedException {

        setId(id.replace("B-", ""));

        HttpRequest getCoordsRequest = HttpRequest.newBuilder()
                .uri(new URI(String.format("https://w33.bcn.cat/geoBCN/serveis/territori/barris/%s", id)))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(getCoordsRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        BarriCoords barriCoords = gson.fromJson(postResponse.body(), BarriCoords.class);

        Double x = barriCoords.getResultats().get(0).getLocalitzacio().getX();
        Double y = barriCoords.getResultats().get(0).getLocalitzacio().getY();

        LatLng latLng = CoordParser.convertToLatLng(x, y, 31, false);

        setLon(latLng.getLng());
        setLat(latLng.getLat());
    }
}
