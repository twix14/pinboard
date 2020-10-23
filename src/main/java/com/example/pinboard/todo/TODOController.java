package com.example.pinboard.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
  private TODOService todoService;

  @PostMapping("/todo/add")
  public TODO addTODO(@RequestBody TODO todo) {
    return todoService.saveTODO(todo);
  }

  @GetMapping("/todos")
  public List<TODO> findAllTODOs() {
    return todoService.getTODOs();
  }

  @GetMapping("/todo/{id}")
  public TODO findTODObyId(@PathVariable long id) {
    return todoService.getTODOById(id);
  }

  @PutMapping("/todo/update")
  public TODO updateTODO(@RequestBody TODO todo) {
    return todoService.updateTODO(todo);
  }

  @DeleteMapping("/todo/{id}")
  public void deleteTODO(@PathVariable long id) {
    todoService.deleteTODO(id);
  }

}
