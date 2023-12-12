package spring.io.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.io.springdatajpa.dao.CourseSpringDataJpaRepository;
import spring.io.springdatajpa.model.Course;

@Component
public class SpringDataJpaCommandLineRunner implements CommandLineRunner {
    
    @Autowired
    private CourseSpringDataJpaRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        courseRepository.save(new Course(1, "Learn AWS Spring Jpa!", "Author1"));
        courseRepository.save(new Course(2, "Learn DevOps Spring Jpa!", "Author2"));
        courseRepository.save(new Course(3, "Learn DS&Algo Spring Jpa!", "Author2"));
        courseRepository.save(new Course(4, "Learn Web Development Spring Jpa!", "Author1"));

        courseRepository.deleteById(1l);

        System.out.println(courseRepository.findById(3l));
        System.out.println(courseRepository.findById(2l));

        System.out.println(courseRepository.findAll());
        System.out.println(courseRepository.count());

        System.out.println(courseRepository.findByAuthor("Author2"));
        System.out.println(courseRepository.findByName("Learn Web Development Spring Jpa!"));
    }
}
