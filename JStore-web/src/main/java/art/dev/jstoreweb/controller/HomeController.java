package art.dev.jstoreweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {

  @RequestMapping
  public String welcome() {
    return "welcome";
  }

}
