package com.example.pinboard.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TODORepository extends JpaRepository<TODO, Long> {

  @Query("SELECT td FROM TODO td" 
         + " JOIN User usr"
         + " ON usr.id = td.user" 
         + " WHERE usr.username = ?1")
  List<TODO> findAllByUser(String username);

}