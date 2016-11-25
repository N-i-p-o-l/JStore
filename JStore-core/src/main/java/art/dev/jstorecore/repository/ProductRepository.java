package art.dev.jstorecore.repository;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCatalog(Catalog catalog);
}
