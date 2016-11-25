package art.dev.jstorecore.repository;

import art.dev.jstorecore.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}
