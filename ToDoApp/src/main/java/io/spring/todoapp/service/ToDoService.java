package io.spring.todoapp.service;

import io.spring.todoapp.model.ToDo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ToDoService {
    private static List<ToDo> toDos;
    static {
        toDos.add(new ToDo(1, "user1", "Learn AWS", LocalDate.now().plusMonths(3), false));
        toDos.add(new ToDo(1, "user1", "Learn AWS", LocalDate.now().plusMonths(3), false));
        toDos.add(new ToDo(1, "user1", "Learn AWS", LocalDate.now().plusMonths(3), false));
    }
}
