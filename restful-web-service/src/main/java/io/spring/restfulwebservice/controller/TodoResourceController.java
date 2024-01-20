package io.spring.restfulwebservice.controller;

import io.spring.restfulwebservice.model.ToDo;
import io.spring.restfulwebservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class TodoResourceController {

    private TodoService todoService;

    @Autowired
    public TodoResourceController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{userName}/todos")
    public List<ToDo> retrieveTodos(@PathVariable String userName) {
       return  todoService.findByUser(userName);
    }
}
