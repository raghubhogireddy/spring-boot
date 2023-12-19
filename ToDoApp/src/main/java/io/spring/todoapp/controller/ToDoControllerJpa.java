package io.spring.todoapp.controller;

import io.spring.todoapp.model.ToDo;
import io.spring.todoapp.repository.ToDoRepository;
import io.spring.todoapp.service.AuthService;
import io.spring.todoapp.service.ToDoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final ToDoRepository toDoRepository;

    public ToDoControllerJpa(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public String listAllToDos(ModelMap modelMap) {
        String userName = getLoggedInUser(modelMap);
        List<ToDo> toDos = toDoRepository.findByUserName(userName);
        modelMap.put("todos", toDos);
        return "listToDos";
    }

    private static String getLoggedInUser(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        modelMap.put("name", authentication.getName());
        return authentication.getName();
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addToDo(ModelMap modelMap) {
        ToDo toDo = new ToDo(0, getLoggedInUser(modelMap), "", LocalDate.now().plusYears(1), false);
        modelMap.put("toDo", toDo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addToDo(ModelMap modelMap, @Valid ToDo toDo, BindingResult result) {
        if (result.hasErrors())
            return "todo"; // "error message not visible if we redirect to /add-todo endpoint"
        String username = getLoggedInUser(modelMap);
        toDo.setUserName(username);
        toDoRepository.save(toDo);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteToDo(@RequestParam int id) {
        toDoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String updateToDo( ModelMap modelMap, @RequestParam int id) {
        ToDo toDo = toDoRepository.findById(id).get();
        modelMap.put("toDo", toDo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateToDo(ModelMap modelMap, @Valid ToDo toDo, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:update-todo";
        }
        String username = getLoggedInUser(modelMap);
        toDo.setUserName(username);
        toDoRepository.save(toDo);
        return "redirect:list-todos";
    }
}
