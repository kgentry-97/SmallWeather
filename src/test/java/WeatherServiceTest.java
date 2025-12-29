import com.fasterxml.jackson.databind.ObjectMapper;
import kgcomputers.model.RealTimeWeatherResponse;
import kgcomputers.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.RequestHeadersUriSpec;
import org.springframework.web.client.RestClient.RequestHeadersSpec;
import org.springframework.web.client.RestClient.ResponseSpec;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {

    private RestClient mockRestClient;
    private WeatherService weatherService;

    @BeforeEach
    public void beforeEach() {
        mockRestClient = mock(RestClient.class);
        weatherService = new WeatherService(mockRestClient);
    }

   /* @Test
    public void testGetRealTimeWeather() throws IOException {
        String location = "denver";
        String apiKey = "123456";
        String units = "metric";
        String url = String.format("https://api.tomorrow.io/v4/weather/realtime?location=%s&apikey=%s", location, apiKey);

        RequestHeadersUriSpec<?> mockUriSpec = mock(RestClient.RequestHeadersUriSpec.class);
        RestClient.RequestHeadersSpec<?> mockRequestHeadersSpec = mock(RestClient.RequestHeadersSpec.class);
        ResponseSpec mockResponseSpec = mock(RestClient.ResponseSpec.class);
        when(mockRestClient.get()).thenReturn(mockUriSpec);
        when(mockUriSpec.uri(url)).thenReturn(mockUriSpec);
        when(mockUriSpec.retrieve()).thenReturn(mockResponseSpec);

        RealTimeWeatherResponse testResponse = new RealTimeWeatherResponse();
        String mockStringResponse = Files.readString(Path.of("src/test/resources/responsetest.json"));
        ObjectMapper mapper = new ObjectMapper();
        try {
            testResponse = mapper.readValue(new File("src/test/resources/responsetest.json"), RealTimeWeatherResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        when(mockRestClient.get().uri(url).retrieve().body(RealTimeWeatherResponse.class)).thenReturn(testResponse);
        assertEquals(testResponse, weatherService.getRealTimeWeather(location, units));
    }*/
}
