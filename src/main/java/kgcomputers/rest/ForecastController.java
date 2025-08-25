package kgcomputers.rest;

import kgcomputers.model.WeatherForecastResponse;
import kgcomputers.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/forecast")
public class ForecastController {

    private final WeatherService weatherService;

    @Autowired
    public ForecastController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/{location}")
    public String getForecastLocation(@PathVariable String location, Model model) {
        return getForecastLocationUnits(location,getSystemDefaultUnits(), model);
    }

    @GetMapping("/{location}/{units}")
    public String getForecastLocationUnits(@PathVariable String location, @PathVariable String units, Model model) {
        WeatherForecastResponse forecast = weatherService.getThreeDayForecast(location, units);
        model.addAttribute("forecast", forecast);
        model.addAttribute("location", location);
        model.addAttribute("units", units);
        return "forecast";
    }

    private String getSystemDefaultUnits() {
        Locale systemLocale = Locale.getDefault();
        if (systemLocale.equals(Locale.US) || systemLocale.getCountry().equals("LR") || systemLocale.getCountry().equals("MM")) {
            return "imperial";
        }
        return "metric";
    }
} 