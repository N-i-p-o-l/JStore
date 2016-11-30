package art.dev.jstorecore.entity;

public enum Role {

  ADMIN("ROLE_ADMIN"),
  USER("ROLE_USER");

  Role(String userRole) {
    this.userRole = userRole;
  }

  String userRole;

  public String getUserRole() {
    return userRole;
  }
}
