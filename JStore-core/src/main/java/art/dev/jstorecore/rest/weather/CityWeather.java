package art.dev.jstorecore.rest.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CityWeather {

  @JsonProperty("main")
  public Temp temp;
}
