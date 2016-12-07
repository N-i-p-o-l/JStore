package art.dev.jstorecore.entity;

import art.dev.jstorecore.annotation.UsernameUnique;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {

  public Customer() {
    this.setRole(Role.USER);
  }

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  @Size(min = 3, message = "Login must be at least 3 characters!")
  @UsernameUnique(message = "Such login already exists")
  private String login;

  @Size(min = 6, message = "Password must be at least 6 characters!")
  private String password;

  @Email(message = "Invalid e-mail address!")
  @Size(min = 3, message = "E-mail must be at least 3 characters!")
  private String email;

  private Role role;

  @Enumerated(EnumType.ORDINAL)
  public Role getRole() {
    return role;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Customer other = (Customer) obj;
    return Objects.equals(id, other.id)
        && Objects.equals(login, other.login);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setRole(Role role) {
    this.role = role;
  }

}
