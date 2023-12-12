package spring.io.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring.io.jdbc.model.Course;

@Repository
public class CourseRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String INSERT_QUERY =
            """
                insert into course (id, name, author)
                values (?, ?, ?);
            """;
    private static final String DELETE_QUERY =
            """
                delete from course where id = ?;
            """;
    
    private static final String SELECT_QUERY =
            """
                select * from course where id = ?;
            """;
    
    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(),
                course.getName(), course.getAuthor());
    }
    
    public void deleteById(int id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }
    
    public Course findById(int id) {
        // ResultSet -> Bean => Row Mapper = BeanPropertyRowMapper
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
    
}
