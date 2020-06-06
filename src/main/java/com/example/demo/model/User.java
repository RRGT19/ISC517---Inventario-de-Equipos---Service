package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "users")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "user_id"))
})
public class User extends BaseEntity {

  @NotEmpty(message = "*Please provide a username")
  private String username;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Length(min = 3, message = "*Your password must have at least 3 characters")
  @NotEmpty(message = "*Please provide your password")
  private String password;

  @NotEmpty(message = "*Please provide your name")
  private String name;

  @NotEmpty(message = "*Please provide your last name")
  private String lastName;

  private boolean active;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
          name = "user_role",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private Set<Role> roles;

  public User() {

  }

  public User(@NotEmpty(message = "*Please provide a username") String username, @Length(min = 6, message = "*Your password must have at least 6 characters") @NotEmpty(message = "*Please provide your password") String password, @NotEmpty(message = "*Please provide your name") String name, @NotEmpty(message = "*Please provide your last name") String lastName, boolean active, Set<Role> roles) {
    this.username = username;
    this.password = password;
    this.name = name;
    this.lastName = lastName;
    this.active = active;
    this.roles = roles;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public boolean getActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
