package com.example.pinboard.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.pinboard.utils.StringArrayConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class User {

  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

  @Id @GeneratedValue
  private long id;
  @Column(nullable = false, unique = true)
  private String username;
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;
  @Convert(converter = StringArrayConverter.class)
  private List<String> roles;

  public User() {
  }

  public User(String username, String password, List<String> roles) {
    this.username = username;
    setPassword(password);
    this.roles = roles;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = PASSWORD_ENCODER.encode(password);
  }

  public List<String> getRoles() {
    return this.roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public User id(long id) {
    this.id = id;
    return this;
  }
  
}
