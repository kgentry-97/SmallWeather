package kgcomputers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeatherData {
    @JsonProperty("time")
    private String time;
    @JsonProperty("values")
    private WeatherValues values;

}
