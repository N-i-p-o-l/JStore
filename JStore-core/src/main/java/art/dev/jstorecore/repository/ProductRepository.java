package art.dev.jstorecore.repository;

import art.dev.jstorecore.entity.Catalog;
import art.dev.jstorecore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCatalog(Catalog catalog);

  @Query(value = "select * from Product where name ilike %?1% AND catalog_id = ?2", nativeQuery = true)
  List<Product> filterByNameAndCatalogId(@Param("name") String name, @Param("id") long id);
}
