package kgcomputers.rest;

import kgcomputers.model.RealTimeWeatherResponse;
import kgcomputers.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String getRealTimeWeatherLocation(@PathVariable String location,
                                             @RequestParam(defaultValue = "metric") String units,
                                             Model model) {
       return getRealTimeWeatherLocationUnits(location, units, model);
    }

    @GetMapping("/realtime/{location}/{units}")
    public String getRealTimeWeatherLocationUnits(@PathVariable String location, @PathVariable String units,
                                             Model model) {
        var weatherData = weatherService.getRealTimeWeather(location, units);

        model.addAttribute("location", location);
        model.addAttribute("units", units);
        model.addAttribute("weather", weatherData.getData().getValues());
        return "realtime-weather";
    }

}
