package org.hackathon.grup3.app.model.coords;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "codi",
        "nom",
        "localitzacio"
})
@Generated("jsonschema2pojo")
public class Resultat {

    @JsonProperty("codi")
    private String codi;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("localitzacio")
    private Localitzacio localitzacio;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("codi")
    public String getCodi() {
        return codi;
    }

    @JsonProperty("codi")
    public void setCodi(String codi) {
        this.codi = codi;
    }

    @JsonProperty("nom")
    public String getNom() {
        return nom;
    }

    @JsonProperty("nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    @JsonProperty("localitzacio")
    public Localitzacio getLocalitzacio() {
        return localitzacio;
    }

    @JsonProperty("localitzacio")
    public void setLocalitzacio(Localitzacio localitzacio) {
        this.localitzacio = localitzacio;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
