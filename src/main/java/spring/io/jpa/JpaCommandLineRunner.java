package spring.io.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.io.jpa.model.Course;
import spring.io.jpa.dao.CourseJpaRepository;

@Component
public class JpaCommandLineRunner implements CommandLineRunner {
    
    @Autowired
    private CourseJpaRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        courseRepository.insert(new Course(1, "Learn AWS Jpa!", "Author1"));
        courseRepository.insert(new Course(2, "Learn DevOps Jpa!", "Author2"));
        courseRepository.insert(new Course(3, "Learn DS&Algo Jpa!", "Author3"));
        courseRepository.insert(new Course(4, "Learn Web Development Jpa!", "Author4"));

        courseRepository.deleteById(1);

        System.out.println(courseRepository.findById(3));
        System.out.println(courseRepository.findById(2));
    }
}
