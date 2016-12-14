package art.dev.jstorecore.repository;

import art.dev.jstorecore.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Repository
public class StoredProcedureRepository {

  @PersistenceContext EntityManager entityManager;

  public List<Product> findProductOverPrice(Long price, Long catalogId) {
    StoredProcedureQuery query = entityManager
        .createStoredProcedureQuery("PRODUCT_OVER_PRICE_V1")
        .registerStoredProcedureParameter("_price", Long.class, ParameterMode.IN)
        .registerStoredProcedureParameter("_catalog_id", Long.class, ParameterMode.IN)
        .setParameter("_price", price)
        .setParameter("_catalog_id", catalogId);
    query.execute();

    List<Product> list = new LinkedList<>();
    query.getResultList().forEach(t -> list.add(new Product((Object[])t)));

    return list;
  }
}
