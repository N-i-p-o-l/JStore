package art.dev.jstorecore.bean;

import art.dev.jstorecore.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@Scope(value= WebApplicationContext.SCOPE_SESSION,
    proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

  private Map<Product, Integer> contents;

  public Cart() {
    this.contents = new HashMap<>();
  }

  public void addProduct(Product product, int count) {

    if (contents.containsKey(product)) {
      contents.put(product, contents.get(product) + count);
    }
    else {
      contents.put(product, count);
    }
  }

  public double getTotalCost() {
    return contents.keySet().stream().mapToLong(Product::getPrice).sum();
  }

  public Map<Product, Integer> getContents() {
    return contents;
  }

  public Set<Product> getProducts() {
    return contents.keySet();
  }

  public void removeProduct(Product product) {
    contents.remove(product);
  }

  public void clearCart() {
    contents.clear();
  }
}
