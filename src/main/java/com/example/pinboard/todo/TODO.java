package com.example.pinboard.todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TODO {
  
  @Id @GeneratedValue
  private long id;
  private String title;

  public TODO() {
  }

  public TODO(String title) {
    this.title = title;
  }

  public long getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
