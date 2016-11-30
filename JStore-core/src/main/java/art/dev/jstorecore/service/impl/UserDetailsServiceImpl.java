package art.dev.jstorecore.service.impl;

import art.dev.jstorecore.entity.Customer;
import art.dev.jstorecore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Collection;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired CustomerRepository userRepository;

  @Override public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    Customer customer = null;

    try {
      customer = userRepository.findByLogin(login);
    } catch (NoResultException e) {
      return null;
    }

    Collection<SimpleGrantedAuthority> authorities = new ArrayList();
    authorities.add(new SimpleGrantedAuthority(customer.getRole().getUserRole()));

    return new User(customer.getLogin(), customer.getPassword(), authorities);
  }
}
