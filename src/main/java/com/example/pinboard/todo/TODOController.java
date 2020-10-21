package com.example.pinboard.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TODOController {
  
  @Autowired
  private TODOService service;

  @PostMapping("/todo/add")
  public TODO addTODO(@RequestBody TODO todo) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return service.saveTODO(todo);
  }

  @GetMapping("/todos")
  public List<TODO> findAllTODOs() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return service.getTODOs();
  }

  @GetMapping("/todo/{id}")
  public TODO findTODObyId(@PathVariable long id) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return service.getTODOById(id);
  }

  @PutMapping("/todo/update")
  public TODO updateTODO(@RequestBody TODO todo) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return service.updateTODO(todo);
  }

  @DeleteMapping("/todo/{id}")
  public void deleteTODO(@PathVariable long id) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    service.deleteTODO(id);
  }

}
