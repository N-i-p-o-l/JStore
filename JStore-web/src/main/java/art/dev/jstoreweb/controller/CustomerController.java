package art.dev.jstoreweb.controller;

import art.dev.jstorecore.entity.Customer;
import art.dev.jstorecore.entity.Role;
import art.dev.jstorecore.repository.CustomerRepository;
import art.dev.jstorecore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
  public String processRegisterCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                        BindingResult result) {
    if (result.hasErrors()) {
      return "register";
    }
    customerService.saveCustomer(customer);

    return "redirect:/";
  }

  @GetMapping("/all")
  public ModelAndView getAll() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("customers", customerService.findAll());
    mv.setViewName("customer");
    return mv;
  }

  @GetMapping("/remove")
  @ResponseStatus(HttpStatus.OK)
  public void removeUser(@RequestParam Long id) {
    customerService.removeCustomer(id);
  }

}
