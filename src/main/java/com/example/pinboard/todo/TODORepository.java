package com.example.pinboard.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TODORepository extends JpaRepository<TODO, Long> {
}
