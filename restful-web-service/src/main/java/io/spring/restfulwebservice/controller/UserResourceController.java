package io.spring.restfulwebservice.controller;


import io.spring.restfulwebservice.exception.UserNotFoundException;
import io.spring.restfulwebservice.model.HelloWorld;
import io.spring.restfulwebservice.model.User;
import io.spring.restfulwebservice.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResourceController {

    private UserDaoService userDaoService;

    @Autowired
    public UserResourceController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable long id) {
        User user = userDaoService.findUser(id);
        if (user == null)
            throw  new UserNotFoundException("id: " + id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userDaoService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
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


}
