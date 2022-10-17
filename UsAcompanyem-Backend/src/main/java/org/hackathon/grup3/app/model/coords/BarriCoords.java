package org.hackathon.grup3.app.model.coords;

import java.util.HashMap;
import java.util.List;
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
        "estat",
        "resultats"
})
@Generated("jsonschema2pojo")
public class BarriCoords {

    @JsonProperty("estat")
    private String estat;
    @JsonProperty("resultats")
    private List<Resultat> resultats = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("estat")
    public String getEstat() {
        return estat;
    }

    @JsonProperty("estat")
    public void setEstat(String estat) {
        this.estat = estat;
    }

    @JsonProperty("resultats")
    public List<Resultat> getResultats() {
        return resultats;
    }

    @JsonProperty("resultats")
    public void setResultats(List<Resultat> resultats) {
        this.resultats = resultats;
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