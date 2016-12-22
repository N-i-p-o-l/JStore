package art.dev.jstoreweb.api;

import art.dev.jstorecore.entity.Product;
import art.dev.jstorecore.service.ICatalogService;
import art.dev.jstorecore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductRestController {

  @Autowired IProductService productService;

  @GetMapping
  public @ResponseBody List<Product> getProducts(@RequestParam("price") Long price) {
    return productService.findProductsOverPrice(price, 2L);
  }

}
