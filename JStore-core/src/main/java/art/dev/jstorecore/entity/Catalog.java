package art.dev.jstorecore.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "catalog")
public class Catalog {

  @Id @GeneratedValue
  private Long id;

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

  private String name;

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Catalog other = (Catalog) obj;
    return Objects.equals(id, other.id)
        && Objects.equals(name, other.name);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .omitNullValues()
        .add("id", id)
        .add("name", name)
        .toString();
  }
}
