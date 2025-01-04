package kgcomputers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class WeatherValues {

    @JsonProperty("temperatureF")
    private double getTemperatureF(){
        return temperature * 9/5 + 32;
    }
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

    @JsonProperty("WeatherDescription")
    private String getWeatherDescription(){
        return WeatherCode.fromCode(weatherCode).getDescription();
    }
}
