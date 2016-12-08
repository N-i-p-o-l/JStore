package art.dev.jstoreweb.controller;

import art.dev.jstorecore.service.IWeatherRestTmplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired IWeatherRestTmplService weatherRestTmplService;

  @RequestMapping
  public String welcome(Model model) {
    model.addAttribute("temp", weatherRestTmplService.getTemp());
    return "welcome";
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

}
