package art.dev.jstorecore.service.impl;

import art.dev.jstorecore.entity.Customer;
import art.dev.jstorecore.repository.CustomerRepository;
import art.dev.jstorecore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService implements ICustomerService {

  @Autowired CustomerRepository customerRepository;

  @Override
  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  @Override
  public Customer findCustomerById(Long id) {
    return customerRepository.findOne(id);
  }

  @Override
  public Customer findByLogin(String login) {
    return customerRepository.findByLogin(login);
  }

  @Override
  public void saveCustomer(Customer customer) {
    BCryptPasswordEncoder password = new BCryptPasswordEncoder();
    String encodedPassword = password.encode(customer.getPassword());
    customer.setPassword(encodedPassword);

    customerRepository.save(customer);
  }

  @Override
  public void removeCustomer(Long id) {
    customerRepository.delete(id);
  }
}
