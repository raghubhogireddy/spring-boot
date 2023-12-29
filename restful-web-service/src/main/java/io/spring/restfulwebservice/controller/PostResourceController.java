package io.spring.restfulwebservice.controller;

import io.spring.restfulwebservice.exception.UserNotFoundException;
import io.spring.restfulwebservice.model.Post;
import io.spring.restfulwebservice.model.User;
import io.spring.restfulwebservice.service.PostDaoService;
import io.spring.restfulwebservice.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostResourceController {

    private UserDaoService userDaoService;

    private PostDaoService postDaoService;

    @Autowired
    public PostResourceController(UserDaoService userDaoService, PostDaoService postDaoService) {
        this.userDaoService = userDaoService;
        this.postDaoService = postDaoService;
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getPostsForUser(@PathVariable long id) {
        User user = userDaoService.findUser(id);
        if (user == null)
            throw new UserNotFoundException("id : " + id);

        return user.getPosts();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable long id, @RequestBody @Valid Post post) {
        User user = userDaoService.findUser(id);
        if (user == null)
            throw new UserNotFoundException("id : " + id);

        post.setUser(user);
        Post savedPost = postDaoService.createPost(post);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
