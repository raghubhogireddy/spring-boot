package spring.io.jpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import spring.io.jpa.model.Course;

@Repository
@Transactional
public class CourseJpaRepository {
    
    
    //@Autowired -> we can use autowired but we can use more specific context
    @PersistenceContext  
    private EntityManager entityManager;
    
    public void insert(Course course) {
        entityManager.merge(course);
    }
    
    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }
    
    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
