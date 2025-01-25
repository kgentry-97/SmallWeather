package kgcomputers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class WeatherValues {


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

    @JsonProperty("weatherDescription")
    public String getWeatherDescription(){
        return WeatherCode.fromCode(weatherCode).getDescription();
    }
}
