package com.example.pinboard.config;

import com.example.pinboard.user.User;
import com.example.pinboard.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserService service;
  
  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
      .csrf().disable()
      .authorizeRequests()
      .antMatchers(HttpMethod.POST, "/user/add").hasRole("ADMIN")
      .antMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
      .anyRequest().authenticated()
      .and()
      .httpBasic();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(service).passwordEncoder(User.PASSWORD_ENCODER);
  }

}
