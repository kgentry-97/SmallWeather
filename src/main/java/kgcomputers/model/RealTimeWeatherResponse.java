package kgcomputers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RealTimeWeatherResponse {

    @JsonProperty("data")
    private WeatherData data;

    @JsonProperty("location")
    private LocationData location;


}

