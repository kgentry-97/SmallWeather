package kgcomputers.rest;


import kgcomputers.model.RealTimeWeatherResponse;
import kgcomputers.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    private final WeatherService weatherService;

    @Autowired
    public BaseController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @GetMapping("/")
    public String index() {
        return "Hello, World!";
    }

    @GetMapping("/realtime")
    public RealTimeWeatherResponse getWeather(@RequestParam String location) {
        return weatherService.getRealTimeWeather(location);
    }
}
