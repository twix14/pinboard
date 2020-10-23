package com.example.pinboard.todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.pinboard.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TODO {
  
  @Id @GeneratedValue
  private long id;
  private String title;

  @JsonIgnore
  @ManyToOne
  private User user;

  public TODO() {
  }

  public TODO(String title, User user) {
    this.title = title;
    this.user = user;
  }

  public long getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public User getUser() {
    return this.user;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
