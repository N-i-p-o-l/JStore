package art.dev.jstorecore.service;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.entity.Product;

import java.util.List;

public interface ICatalogService {

  List<Catalog> findAll();

  List<Product> findProductsByCatalogId(Long id);

  Catalog findCatalogById(Long id);

  void saveCatalog(Catalog catalog);

  void removeCatalog(Long id);
}
