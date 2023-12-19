package io.spring.todoapp.repository;

import io.spring.todoapp.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    
    public List<ToDo> findByUserName(String userName);
}
