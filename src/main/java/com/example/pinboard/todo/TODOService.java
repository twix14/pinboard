package com.example.pinboard.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TODOService {

  @Autowired // repository injected
  private TODORepository repository;

  public TODO saveTODO(TODO todo) {
    return repository.save(todo);
  }

  public List<TODO> getTODOs() {
    return repository.findAll();
  }

  public TODO getTODOById(long id) {
    return repository.findById(id).orElse(null);
  }

  public void deleteTODO(long id) {
    repository.deleteById(id);
  }

  public TODO updateTODO(TODO todo) {
    TODO existingTODO = repository.findById(todo.getId()).orElse(null);
    existingTODO.setTitle(todo.getTitle());
    return repository.save(existingTODO);
  }
  
}
