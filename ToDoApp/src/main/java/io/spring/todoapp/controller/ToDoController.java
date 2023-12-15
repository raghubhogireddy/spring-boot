package io.spring.todoapp.controller;

import io.spring.todoapp.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToDoController {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final AuthService service;

    public ToDoController(AuthService service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginJsp() {
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcomeJsp(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if (service.authenticate(name, password)) {
            model.put("name", name);
            return "welcome";
        }else {
            model.put("errorMessage", "Invalid Credentials! Please try again");
            return "login";
        }
    }
}
