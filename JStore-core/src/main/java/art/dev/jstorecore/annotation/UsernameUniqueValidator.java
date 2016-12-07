package art.dev.jstorecore.annotation;

import art.dev.jstorecore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameUniqueValidator implements ConstraintValidator<UsernameUnique, String> {

  @Autowired CustomerRepository customerRepository;

  @Override
  public void initialize(UsernameUnique usernameUnique) {
  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

    return customerRepository == null || customerRepository.findByLogin(s) == null;
  }
}
