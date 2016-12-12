package art.dev.jstoreweb.controller;

import art.dev.jstorecore.rest.weather.CityWeather;
import art.dev.jstorecore.service.IWeatherRestTmplService;
import art.dev.jstorecore.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired IMailService mailService;
  @Autowired IWeatherRestTmplService weatherRestTmplService;

  @GetMapping
  public String welcome(Model model) {
    return "welcome";
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @GetMapping("/weather")
  public @ResponseBody Float getWeather() {
    return weatherRestTmplService.getTemp();
  }

}
