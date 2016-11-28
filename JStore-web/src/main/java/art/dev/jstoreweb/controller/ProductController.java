package art.dev.jstoreweb.controller;

import art.dev.jstorecore.entity.Product;
import art.dev.jstorecore.service.ICatalogService;
import art.dev.jstorecore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductController {

  @Autowired IProductService productService;
  @Autowired ICatalogService catalogService;

  private Long catalogIdToAdd;

  @GetMapping("/add")
  public String addProduct(@RequestParam Long id, Model model) {
    model.addAttribute("product", new Product());

    //ToDo save to session
    catalogIdToAdd = id;

    return "product-add";
  }

  @PostMapping("/add")
  public String processAddProduct(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file,
                                  HttpServletRequest request) {
    product.setCatalog(catalogService.findCatalogById(catalogIdToAdd));
    productService.saveProduct(product);

    String path = request.getSession().getServletContext().getRealPath("/");
    productService.saveProductImage(product.getId(), file, path);

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
