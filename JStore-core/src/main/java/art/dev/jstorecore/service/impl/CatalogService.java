package art.dev.jstorecore.service.impl;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.repository.CatalogRepository;
import art.dev.jstorecore.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CatalogService implements ICatalogService {

  @Autowired private CatalogRepository catalogRepository;

  @Override public List<Catalog> findAll() {
    return catalogRepository.findAll();
  }

  @Override public Catalog findCatalogById(Long id) {
    return catalogRepository.findOne(id);
  }

  @Override public void saveCatalog(Catalog catalog) {
    catalogRepository.save(catalog);
  }

  @Override public void removeCatalog(Long id) {
    catalogRepository.delete(id);
  }
}
