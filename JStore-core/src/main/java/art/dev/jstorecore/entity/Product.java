package art.dev.jstorecore.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

  @Id @GeneratedValue
  private Long id;

  private String name;

  private String description;

  private long unitsInStock;

  private long price;

  @ManyToOne
  @JoinColumn(name = "catalog_id")
  private Catalog catalog;

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Product other = (Product) obj;
    return Objects.equals(id, other.id)
        && Objects.equals(name, other.name);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getUnitsInStock() {
    return unitsInStock;
  }

  public void setUnitsInStock(long unitsInStock) {
    this.unitsInStock = unitsInStock;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public Catalog getCatalog() {
    return catalog;
  }

  public void setCatalog(Catalog catalog) {
    this.catalog = catalog;
  }
}
