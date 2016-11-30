package art.dev.jstorecore.service;

import art.dev.jstorecore.entity.Customer;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ICustomerService {

  List<Customer> findAll();

  Customer findCustomerById(Long id);

  Customer findByLogin(String login);

  void saveCustomer(Customer customer);

  void removeCustomer(Long id);
}
