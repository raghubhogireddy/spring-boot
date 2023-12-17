package io.spring.todoapp.controller;

import io.spring.todoapp.model.ToDo;
import io.spring.todoapp.service.AuthService;
import io.spring.todoapp.service.ToDoService;
import jakarta.validation.Valid;
import org.apache.catalina.LifecycleState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ToDoController {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final AuthService authService;
    private final ToDoService toDoService;

    public ToDoController(AuthService authService, ToDoService toDoService) {
        this.authService = authService;
        this.toDoService = toDoService;
    }
    
    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public String listAllToDos(ModelMap modelMap) {
        List<ToDo> toDos = toDoService.findByUser("");
        modelMap.put("todos", toDos);
        return "listToDos";
    } 
    
    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String addToDo(ModelMap modelMap) {
        ToDo toDo = new ToDo(0, (String) modelMap.get("name"), "", LocalDate.now().plusYears(1), false);
        modelMap.put("toDo", toDo);
        return "todo";
    }
    
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addToDo(ModelMap modelMap, @Valid ToDo toDo, BindingResult result) {
        if (result.hasErrors()) 
            return "todo"; // "error message not visible if we redirect to /add-todo endpoint"
        String username = (String) modelMap.get("name");
        toDoService.addToDo(username, toDo.getDescription(), toDo.getTargetDate(), false);
        return "redirect:list-todos";
    }
    
    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteToDo(@RequestParam int id) {
        toDoService.deleteToDo(id);
        return "redirect:list-todos";
    }
    
    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String updateToDo( ModelMap modelMap, @RequestParam int id) {
        ToDo toDo = toDoService.findById(id);
        modelMap.put("toDo", toDo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateToDo(ModelMap modelMap, @Valid ToDo toDo, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:update-todo";
        }
        String username = (String) modelMap.get("name");
        toDo.setUserName(username);
        toDoService.updateToDo(toDo);
        return "redirect:list-todos";
    }
    
    
}
