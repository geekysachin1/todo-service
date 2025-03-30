package com.spring.jpa.training.jdbc.respository;

import com.spring.jpa.training.jdbc.entities.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CourseRepository {

    private JdbcTemplate jdbcTemplate;
    private final String INSERT_QUERY =
            """
                        insert into cources(id, name, author)
                        values (?,?,?);
                    """;
    private static final String SELECT_QUERY = """
            select * from cources where id=?;
            """;


    public CourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public Course query(long id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
