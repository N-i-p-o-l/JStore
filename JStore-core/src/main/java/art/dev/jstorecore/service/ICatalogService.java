package art.dev.jstorecore.service;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.entity.Product;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ICatalogService {

  List<Catalog> findAll();

  Catalog findCatalogById(Long id);

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  void saveCatalog(Catalog catalog);

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  void removeCatalog(Long id);
}
