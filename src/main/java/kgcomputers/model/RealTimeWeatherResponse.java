package kgcomputers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealTimeWeatherResponse {
    @JsonProperty("data")
    private WeatherData data;

    @JsonProperty("location")
    private LocationData location;


}

@Getter
@Setter
class WeatherData {
    @JsonProperty("time")
    private String time;
    @JsonProperty("values")
    private WeatherValues values;


}

