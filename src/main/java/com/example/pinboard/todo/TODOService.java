package com.example.pinboard.todo;

import java.util.List;

import com.example.pinboard.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TODOService {

  @Autowired // repository injected
  private TODORepository todoRepository;
  @Autowired
  private UserRepository userRepository;

  public TODO saveTODO(TODO todo) {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    todo.setUser(userRepository.findByUsername(username));
    return todoRepository.save(todo);
  }

  public List<TODO> getTODOs() {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    return todoRepository.findAllByUser(username);
  }

  public TODO getTODOById(long id) {
    return todoRepository.findById(id).orElse(null);
  }

  public void deleteTODO(long id) {
    todoRepository.deleteById(id);
  }

  public TODO updateTODO(TODO todo) {
    TODO existingTODO = todoRepository.findById(todo.getId()).orElse(null);
    existingTODO.setTitle(todo.getTitle());
    return todoRepository.save(existingTODO);
  }
  
}
