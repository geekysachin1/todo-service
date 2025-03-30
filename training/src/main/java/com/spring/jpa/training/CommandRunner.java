package com.spring.jpa.training.jpa;

import com.spring.jpa.training.jpa.entities.CourseEntity;
import com.spring.jpa.training.jpa.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JpaCommandRunner implements CommandLineRunner {
    private final CourseRepository courseRepository;

    public JpaCommandRunner(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        courseRepository.insert(new CourseEntity(3, "Learn Azure", "SJ"));
        var cource = courseRepository.findById(3);
        System.out.println(cource.toString());
    }
}
