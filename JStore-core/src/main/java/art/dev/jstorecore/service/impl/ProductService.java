package art.dev.jstorecore.service.impl;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.entity.Product;
import art.dev.jstorecore.repository.CatalogRepository;
import art.dev.jstorecore.repository.ProductRepository;
import art.dev.jstorecore.repository.StoredProcedureRepository;
import art.dev.jstorecore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {

  private static final int PAGE_SIZE = 5;

  @Autowired private ProductRepository productRepository;
  @Autowired private CatalogRepository catalogRepository;
  @Autowired private StoredProcedureRepository storedRepository;

  private final static String imagesPath = "resources\\images\\";

  @Override
  public List<Product> findProductByCatalog(Catalog catalog) {
    return productRepository.findByCatalog(catalog);
  }

  @Override
  public List<Product> filterByNameAndCatalogId(String name, long id) {
    return productRepository.filterByNameAndCatalogId(name, id);
  }

  @Override public List<Product> findProductsByCatalogId(Long id) {
    Catalog catalog = catalogRepository.findOne(id);
    return productRepository.findByCatalog(catalog);
  }

  @Override public Page<Product> findProductByCatalogPage(Integer pageNumber, Long id) {
    PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "name");
    Catalog catalog = catalogRepository.findOne(id);
    return productRepository.findByCatalog(request, catalog);
  }

  @Override
  public List<Product> findProductsOverPrice(Long price, Long catalog) {
    return storedRepository.findProductOverPrice(price, catalog);
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

  @Override
  public void saveProductImage(Long id, MultipartFile file, String path) {
    if (file != null && !file.isEmpty()) {
        try {
          file.transferTo(new File(path + imagesPath + id + ".png"));
        } catch (IOException e) {
            throw new RuntimeException("Product Image saving failed", e);
      }
    }
  }
}
