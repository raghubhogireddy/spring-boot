package spring.io.springdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.io.springdatajpa.model.Course;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
