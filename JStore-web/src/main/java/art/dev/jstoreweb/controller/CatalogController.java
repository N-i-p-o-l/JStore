package art.dev.jstoreweb.controller;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.entity.Product;
import art.dev.jstorecore.service.ICatalogService;
import art.dev.jstorecore.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

  @Autowired ICatalogService catalogService;
  @Autowired IProductService productService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("catalogs", catalogService.findAll());

    return "catalog-list";
  }

  @GetMapping("/add")
  public String addCatalog(Model model) {
    model.addAttribute("catalog", new Catalog());

    return "catalog-add";
  }

  @PostMapping("/add")
  public String processAddCatalog(@ModelAttribute("catalog") Catalog catalog) {
    catalogService.saveCatalog(catalog);

    return "redirect:/catalog";
  }

  @GetMapping("{id}")
  public String catalogProducts(@PathVariable Long id, Model model, HttpSession session) {
    session.setAttribute("catalog_id", id);

    return "redirect:/catalog/pages/1";
  }

  @GetMapping("/pages/{number}")
  public String catalogProductsPage(@PathVariable Integer number, Model model, HttpSession session) {
    Long id = (Long) session.getAttribute("catalog_id");
    Page<Product> page = productService.findProductByCatalogPage(number, id);

    int current = page.getNumber() + 1;
    int begin = Math.max(1, current - 5);
    int end = Math.min(begin + 10, page.getTotalPages());

    model.addAttribute("page", page);
    model.addAttribute("beginIndex", begin);
    model.addAttribute("endIndex", end);
    model.addAttribute("currentIndex", current);

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

  @PostMapping("/filter")
  public String getFilteredProducts(HttpServletRequest request, HttpSession session, Model model) {
    String name = request.getParameter("name");
    Long id = (Long) session.getAttribute("catalog_id");
    model.addAttribute("products", productService.filterByNameAndCatalogId(name, id));

    return "catalog-products";
  }

}
