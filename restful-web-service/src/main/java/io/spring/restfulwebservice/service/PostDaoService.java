package io.spring.restfulwebservice.service;

import io.spring.restfulwebservice.model.Post;
import io.spring.restfulwebservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDaoService {

    private PostRepository postRepository;

    @Autowired
    public PostDaoService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post)  {
       return postRepository.save(post);
    }
}
