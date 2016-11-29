package art.dev.jstoreweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  @RequestMapping
  public String welcome() {
    return "welcome";
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

}
