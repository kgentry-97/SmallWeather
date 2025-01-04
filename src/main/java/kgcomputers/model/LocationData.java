package kgcomputers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class LocationData {
    @JsonProperty("lat")
    private double lat;
    @JsonProperty("lon")
    private double lon;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
}
