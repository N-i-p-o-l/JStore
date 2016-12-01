package art.dev.jstoreweb.controller;

import art.dev.jstorecore.bean.Cart;
import art.dev.jstorecore.entity.Product;
import art.dev.jstorecore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/cart")
public class CartController {

  @Autowired private Cart cart;
  @Autowired private IProductService productService;

  @GetMapping("/add/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void addToCart(@PathVariable("id") Long id) {
    Product product = productService.findProductById(id);
    cart.addProduct(product, 1);
  }

  @RequestMapping
  public String showCart(Model model) {
    model.addAttribute(cart);
    return "cart";
  }

}
