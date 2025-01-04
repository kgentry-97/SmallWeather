package kgcomputers.service;

import kgcomputers.model.RealTimeWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${tomorrow.api.key}")
    private String apiKey;

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public RealTimeWeatherResponse getRealTimeWeather(String location) {
        String url = String.format("https://api.tomorrow.io/v4/weather/realtime?location=%s&apikey=%s", location, apiKey);
        return restTemplate.getForObject(url, RealTimeWeatherResponse.class);
    }

}
