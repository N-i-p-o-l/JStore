package art.dev.jstoreweb.controller;

import art.dev.jstorecore.entity.Product;
import art.dev.jstorecore.service.ICatalogService;
import art.dev.jstorecore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

  @Autowired IProductService productService;
  private Long catalogIdToAdd;

  @GetMapping("/add")
  public String addProduct(@RequestParam Long id, Model model) {
    model.addAttribute("product", new Product());
    catalogIdToAdd = id;
    return "product-add";
  }

  @PostMapping("/add")
  public String processAddProduct(@ModelAttribute("product") Product product) {
    return "redirect:/catalog/" + catalogIdToAdd;
  }

  @GetMapping("/edit")
  public String editProduct(@RequestParam Long id, Model model) {
    model.addAttribute("product", productService.findProductById(id));
    return "product-add";
  }

  @GetMapping("/remove")
  public String removeProduct(@RequestParam Long id) {
    productService.removeProduct(id);
    return "redirect:/catalog/" + catalogIdToAdd;
  }

}
