package spring.io.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AppController {

    private AppConfig appConfig;

    @Autowired
    public AppController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return Arrays.asList(
                new Course(1, "learn AWS", "author1"),
                new Course(2, "learn DevOps", "author2"),
                new Course(3, "learn Kubernetes", "author3"),
                new Course(4, "learn Java", "author4"),
                new Course(5, "learn Junit", "author5")
        );
    }

    @RequestMapping("/appConfig")
    public AppConfig getAppConfig() {
        return appConfig;
    }
}

class Course {
    private int id;
    private String name;
    private String author;

    public Course(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
