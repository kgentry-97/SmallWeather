package kgcomputers.rest;

import kgcomputers.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
@RequestMapping("/realtime")
public class RealTimeController {

    private final WeatherService weatherService;

    @Autowired
    public RealTimeController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{location}")
    public String getRealTimeWeatherLocation(@PathVariable String location, Model model) {
       return getRealTimeWeatherLocationUnits(location, getSystemDefaultUnits(), model);
    }

    @GetMapping("/{location}/{units}")
    public String getRealTimeWeatherLocationUnits(@PathVariable String location, @PathVariable String units,
                                             Model model) {
        var weatherData = weatherService.getRealTimeWeather(location, units);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm:ss").withZone(java.time.ZoneId.systemDefault());
        String formattedTime = ZonedDateTime.parse(weatherData.getData().getTime()).format(formatter);

        model.addAttribute("location", weatherData.getLocation().getName());
        model.addAttribute("time", formattedTime);
        model.addAttribute("units", units);
        model.addAttribute("weather", weatherData.getData().getValues());
        return "realtime-weather";
    }

    private String getSystemDefaultUnits() {
        Locale systemLocale = Locale.getDefault();
        if (systemLocale.equals(Locale.US) || systemLocale.getCountry().equals("LR") || systemLocale.getCountry().equals("MM")) {
            return "imperial";
        }
        return "metric";
    }

}
