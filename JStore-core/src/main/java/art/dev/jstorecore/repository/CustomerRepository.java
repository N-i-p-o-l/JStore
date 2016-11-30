package art.dev.jstorecore.repository;

import art.dev.jstorecore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Customer findByLogin(String login);
}
