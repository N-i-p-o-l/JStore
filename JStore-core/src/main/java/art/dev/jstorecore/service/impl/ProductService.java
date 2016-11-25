package art.dev.jstorecore.service.impl;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.entity.Product;
import art.dev.jstorecore.repository.ProductRepository;
import art.dev.jstorecore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {

  @Autowired private ProductRepository productRepository;

  @Override
  public List<Product> findProductByCatalog(Catalog catalog) {
    return productRepository.findByCatalog(catalog);
  }

  @Override
  public Product findProductById(Long id) {
    return productRepository.findOne(id);
  }

  @Override
  public void saveProduct(Product product) {
    productRepository.save(product);
  }

  @Override
  public void removeProduct(Long id) {
    productRepository.delete(id);
  }
}
