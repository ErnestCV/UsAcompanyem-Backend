package org.hackathon.grup3.app.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 *  A place on Earth, represented by a latitude/longitude pair.
 */
@Getter
@Setter
public class LatLng {

    /** The latitude of this location. */
    private double lat;

    /** The longitude of this location. */
    private double lng;

    /**
     * Constructs a location with a latitude/longitude pair.
     *
     * @param lat The latitude of this location.
     * @param lng The longitude of this location.
     */
    public LatLng(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%.8f,%.8f", lat, lng);
    }
}
