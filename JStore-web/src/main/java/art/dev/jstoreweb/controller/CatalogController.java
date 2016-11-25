package art.dev.jstoreweb.controller;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.entity.Product;
import art.dev.jstorecore.service.ICatalogService;
import art.dev.jstorecore.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

  @Autowired ICatalogService catalogService;

  @RequestMapping
  public String list(Model model) {
    model.addAttribute("catalogs", catalogService.findAll());

    return "catalog-list";
  }

  @RequestMapping("/add")
  public String addCatalog(Model model) {
    model.addAttribute("catalog", new Catalog());

    return "catalog-add";
  }

  @PostMapping("/add")
  public String processAddCatalog(@ModelAttribute("catalog") Catalog catalog) {
    catalogService.saveCatalog(catalog);
    return "redirect:/catalog";
  }

  @RequestMapping("{id}")
  public String catalogProducts(@PathVariable Long id, Model model) {
    List<Product> products = catalogService.findProductsByCatalogId(id);
    model.addAttribute("products", products);
    model.addAttribute("id", id);

    return "catalog-products";
  }

  @RequestMapping("/edit")
  public String editCatalog(@RequestParam Long id, Model model) {
    model.addAttribute("catalog", catalogService.findCatalogById(id));
    return "catalog-add";
  }

  @RequestMapping("/remove")
  public String removeCatalog(@RequestParam Long id) {
    catalogService.removeCatalog(id);
    //ToDo return alert additionally to view
    return "redirect:/catalog";
  }

}
