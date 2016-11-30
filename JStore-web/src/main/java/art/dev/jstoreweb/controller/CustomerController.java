package art.dev.jstoreweb.controller;

import art.dev.jstorecore.entity.Customer;
import art.dev.jstorecore.entity.Role;
import art.dev.jstorecore.repository.CustomerRepository;
import art.dev.jstorecore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  @Autowired ICustomerService customerService;

  @GetMapping("/register")
  public String registerCustomer(Model model) {
    model.addAttribute("customer", new Customer());

    return "register";
  }

  @PostMapping("/register")
  public String processRegisterCustomer(@ModelAttribute("customer") Customer customer) {

    //ToDo Check exists username
    customerService.saveCustomer(customer);
    return "redirect:/";
  }
}
