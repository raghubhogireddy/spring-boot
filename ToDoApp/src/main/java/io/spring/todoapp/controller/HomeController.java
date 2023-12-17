package io.spring.todoapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = "name")
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomPage(ModelMap modelMap) {
        modelMap.put("name", "springBoot");
        return "welcome";
    }
}
