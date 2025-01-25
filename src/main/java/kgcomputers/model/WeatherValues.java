package kgcomputers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
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
        System.out.println("Weather Code: " + weatherCode);
        System.out.println("Weather Description: " + WeatherCode.fromCode(weatherCode).getDescription());
        return WeatherCode.fromCode(weatherCode).getDescription();
    }
    @JsonProperty("temperatureF")
    private double getTemperatureF(){
        return convertTemperatureF(temperature);
    }
    @JsonProperty("temperatureApparentF")
    private double getTemperatureApparentF(){
        return convertTemperatureF(temperatureApparent);
    }

    private double convertTemperatureF(double temperature){
        return temperature * 9/5 + 32;
    }

}
