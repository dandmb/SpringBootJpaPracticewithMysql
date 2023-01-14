package com.dmb.SpringJpaCourse.entity;

import com.dmb.SpringJpaCourse.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses=courseRepository.findAll();
        System.out.println("Courses : "+courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher=Teacher.builder()
                .firstName("Young")
                .lastName("Sir")
                .build();
        Course course=Course.builder()
                .title("Python")
                .credit(3)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
        //System.out.println("Courses : "+course);
    }


}