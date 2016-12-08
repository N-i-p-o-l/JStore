package art.dev.jstorecore.service.impl;

import art.dev.jstorecore.rest.weather.CityWeather;
import art.dev.jstorecore.service.IWeatherRestTmplService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherRestTmplService implements IWeatherRestTmplService {

  private final static String URL = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&units=metric";
  private final static String API_KEY = "&appid=e158b48e24a860e87f7c525df1a261a1";

  private RestTemplate restTemplate;

  public WeatherRestTmplService() {
    restTemplate = new RestTemplate();
  }

  @Override public Float getTemp() {
    CityWeather cityWeather = restTemplate.getForObject(URL + API_KEY, CityWeather.class);
    return cityWeather.temp.getTemp();
  }
}
