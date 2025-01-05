package kgcomputers.service;

import kgcomputers.model.RealTimeWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private final RestClient restClient;

    @Value("${tomorrow.api.key}")
    private String apiKey;

    @Autowired
    public WeatherService(RestClient restClient) {
        this.restClient = restClient;
    }

    public RealTimeWeatherResponse getRealTimeWeather(String location) {
        String url = String.format("https://api.tomorrow.io/v4/weather/realtime?location=%s&apikey=%s", location, apiKey);
        return restClient.get().uri(url)
                .retrieve()
                .body(RealTimeWeatherResponse.class);
    }

}
