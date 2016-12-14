package art.dev.jstoreweb.api;

import art.dev.jstorecore.entity.Product;
import art.dev.jstorecore.service.ICatalogService;
import art.dev.jstorecore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductRestController {

  @Autowired IProductService productService;

  @GetMapping("/{id}")
  public @ResponseBody List<Product> getProducts(@PathVariable("id") Long id) {
    return productService.findProductsOverPrice(100L, id);
  }

}
