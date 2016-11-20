package art.dev.jstoreweb.controller;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
