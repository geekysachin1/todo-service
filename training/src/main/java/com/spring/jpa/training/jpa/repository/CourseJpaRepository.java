package com.spring.jpa.training.jpa.repository;

import com.spring.jpa.training.jpa.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public CourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Course cource) {
        entityManager.merge(cource);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }
}
