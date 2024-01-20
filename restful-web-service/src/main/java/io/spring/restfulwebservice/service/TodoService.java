package io.spring.restfulwebservice.service;

import io.spring.restfulwebservice.model.ToDo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static final List<ToDo> toDos;
    private static int todoCount = 0;
    static {
        toDos = new ArrayList<>();
        toDos.add(new ToDo(++todoCount, "admin", "Learn AWS", LocalDate.now().plusMonths(3), false));
        toDos.add(new ToDo(++todoCount, "admin", "Learn AWS", LocalDate.now().plusMonths(3), false));
        toDos.add(new ToDo(++todoCount, "admin", "Learn AWS", LocalDate.now().plusMonths(3), false));
    }

    public List<ToDo> findByUser(String userName) {
        Predicate<? super ToDo> predicate = toDo -> toDo.getUserName().equalsIgnoreCase(userName);
        List<ToDo> list = toDos.stream().filter(predicate).toList();
        return list;
    }

    public void addToDo(String userName, String description, LocalDate date, boolean done ) {
        ToDo toDo = new ToDo(++todoCount, userName, description, date, done);
        toDos.add(toDo);
    }

    public void deleteToDo(int id) {
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        toDos.removeIf(predicate);

    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        return toDos.stream().filter(predicate).findFirst().get();
    }

    public void updateToDo(ToDo toDo) {
        deleteToDo(toDo.getId());
        toDos.add(toDo);
    }
}
