package org.hackathon.grup3.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DistricteBarri {

    private String idBarri;
    private String nomBarri;
    private String idDistricte;
    private String nomDistricte;
}
