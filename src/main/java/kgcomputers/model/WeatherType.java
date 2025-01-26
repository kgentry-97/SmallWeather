package kgcomputers.model;

import java.util.Arrays;
import java.util.List;

public enum WeatherType {
    SUNNY("sunny", Arrays.asList("sunny", "clear")),
    CLOUDY("cloudy", Arrays.asList("cloudy", "overcast", "fog")),
    RAINY("rainy", Arrays.asList("rain", "drizzle", "thunderstorm")),
    SNOWY("snowy", Arrays.asList("snowy", "blizzard", "flurries", "ice"));

    private final String description;
    private final List<String> keywords;

    // Constructor
    WeatherType(String description, List<String> keywords) {
        this.description = description;
        this.keywords = keywords;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Getter for keywords
    public List<String> getKeywords() {
        return keywords;
    }

    public static String mapToWeatherString(String input) {
        if (input == null || input.isEmpty()) {
            return "weather-default";
        }

        String normalizedInput = input.toLowerCase();

        for (WeatherType weatherType : values()) {
            for (String keyword : weatherType.getKeywords()) {
                if (normalizedInput.contains(keyword)) {
                    return "weather-" + weatherType.name().toLowerCase();
                }
            }
        }

        // Return default if no matches found
        return "weather-default";
    }
}
