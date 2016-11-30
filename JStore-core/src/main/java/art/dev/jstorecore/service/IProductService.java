package art.dev.jstorecore.service;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.entity.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductService {

  List<Product> findProductByCatalog(Catalog catalog);

  Product findProductById(Long id);

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  void saveProduct(Product product);

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  void removeProduct(Long id);

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  void saveProductImage(Long id, MultipartFile file, String path);
}
