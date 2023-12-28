package io.spring.restfulwebservice.controller;

import io.spring.restfulwebservice.model.HelloWorld;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(path = "/hello-world", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorld helloWorldBean() {
        return new HelloWorld("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorld helloWorldVariable(@PathVariable String name) {
        return new HelloWorld(String.format("Hello World, %s", name));
    }

    @GetMapping("/hello-world-i8n")
    public String helloWorldLocale() {
        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage("good.morning.message", null, "default message", locale);
        return "Hello World, & " + message;
    }
}
