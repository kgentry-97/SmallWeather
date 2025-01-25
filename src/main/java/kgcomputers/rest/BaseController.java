package kgcomputers.rest;

import kgcomputers.model.RealTimeWeatherResponse;
import kgcomputers.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BaseController {

    private final WeatherService weatherService;

    @Autowired
    public BaseController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/realtime/{location}")
    public String getRealTimeWeatherLocation(@PathVariable String location, Model model) {
        var weatherData = weatherService.getRealTimeWeather(location);

        model.addAttribute("location", location);
        model.addAttribute("weather", weatherData.getData().getValues());
        return "realtime-weather";
    }

}
