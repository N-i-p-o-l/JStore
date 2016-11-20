package art.dev.jstorecore.service;

import art.dev.jstorecore.entity.Catalog;

import java.util.List;

public interface ICatalogService {

  List<Catalog> findAll();

  Catalog findCatalogById(Long id);

  void saveCatalog(Catalog catalog);

  void removeCatalog(Long id);
}
