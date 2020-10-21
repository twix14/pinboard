package com.example.pinboard.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
  
  @Autowired
  private UserRepository repository;

  @Value("${spring.security.user.name}")
  private String admin;
  @Value("${spring.security.user.password}")
  private String adminPassword;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = username.equals(admin) ? getAdmin() : repository.findByUsername(username);
    if (user == null)
      throw new UsernameNotFoundException(username + "was not found");

    return new org.springframework.security.core.userdetails.User(
      user.getUsername(), user.getPassword(),
      AuthorityUtils.createAuthorityList(user.getRoles().toArray(new String[0])));
  }

  private User getAdmin() {
    User user = repository.findByUsername(admin);
    if (user == null)
      user = repository.save(new User(admin, adminPassword, Arrays.asList("ROLE_ADMIN")));
    
    return user;
  }

  public User saveUser(User user) {
    System.out.println(user.getRoles());
    System.out.println(user.getPassword());
    System.out.println(user.getUsername());
    return repository.save(user);
  }

  public User getByUsername(String username) {
    return repository.findByUsername(username);
  }

  public List<User> getUsers() {
    return repository.findAll();
  }

}
