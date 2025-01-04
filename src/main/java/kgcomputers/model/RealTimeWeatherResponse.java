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

@Getter
@Setter
class WeatherValues {

    @JsonProperty("temperature")
    private double temperature;
    @JsonProperty("temperatureApparent")
    private double temperatureApparent;
    @JsonProperty("precipitation")
    private double precipitation;
    @JsonProperty("humidity")
    private double humidity;
    @JsonProperty("windSpeed")
    private double windSpeed;
    @JsonProperty("windDirection")
    private double windDirection;
    @JsonProperty("weatherCode")
    private int weatherCode;
}

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

