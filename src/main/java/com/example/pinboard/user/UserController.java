package com.example.pinboard.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  
  @Autowired
  private UserService service;

  @PostMapping("/user/add")
  public User addUser(@RequestBody User user) {
    return service.saveUser(user);
  }

  @GetMapping("/user")
  public User findUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return service.getByUsername(auth.getName());
  }

  @GetMapping("/users")
  public List<User> findAllUsers() {
    return service.getUsers();
  }

}
