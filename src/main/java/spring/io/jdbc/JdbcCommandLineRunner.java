package spring.io.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.io.jdbc.dao.CourseRepository;
import spring.io.jdbc.model.Course;

@Component
public class JdbcCommandLineRunner implements CommandLineRunner {
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Override
    public void run(String... args) throws Exception {
        courseRepository.insert(new Course(1, "Learn AWS!", "Author1"));
        courseRepository.insert(new Course(2, "Learn DevOps!", "Author2"));
        courseRepository.insert(new Course(3, "Learn DS&Algo!", "Author3"));
        courseRepository.insert(new Course(4, "Learn Web Development!", "Author4"));
        
        courseRepository.deleteById(1);

        System.out.println(courseRepository.findById(3));
        System.out.println(courseRepository.findById(2));
    }
}
