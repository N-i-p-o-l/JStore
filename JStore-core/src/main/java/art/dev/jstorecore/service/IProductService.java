package art.dev.jstorecore.service;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.entity.Product;

import java.util.List;

public interface IProductService {

  List<Product> findProductByCatalog(Catalog catalog);

  Product findProductById(Long id);

  void saveProduct(Product product);

  void removeProduct(Long id);
}
