package kgcomputers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
public class WeatherForecastResponse {
    @JsonProperty("timelines")
    private Timelines timelines;

    @JsonProperty("location")
    private LocationData location;
}

@Getter
@Setter
@Data
@NoArgsConstructor
class Timelines {
    @JsonProperty("daily")
    private List<DailyForecast> daily;
}

@Getter
@Setter
@Data
@NoArgsConstructor
class DailyForecast {
    @JsonProperty("time")
    private String time;
    
    @JsonProperty("values")
    private ForecastValues values;
}

@Getter
@Setter
@Data
@NoArgsConstructor
class ForecastValues {
    @JsonProperty("temperatureMax")
    private double temperatureMax;
    
    @JsonProperty("temperatureMin")
    private double temperatureMin;
    
    @JsonProperty("humidityAvg")
    private double humidityAvg;
    
    @JsonProperty("precipitationProbabilityAvg")
    private double precipitationProbabilityAvg;
    
    @JsonProperty("windSpeedAvg")
    private double windSpeedAvg;
    
    @JsonProperty("cloudCoverAvg")
    private double cloudCoverAvg;
} 