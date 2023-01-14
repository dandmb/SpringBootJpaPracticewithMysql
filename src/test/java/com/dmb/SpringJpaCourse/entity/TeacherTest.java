package com.dmb.SpringJpaCourse.entity;

import com.dmb.SpringJpaCourse.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseA=Course.builder()
                .title("Hist")
                .credit(5)
                .build();

        Course courseB=Course.builder()
                .title("Java")
                .credit(3)
                .build();


        Teacher teacher=Teacher.builder()
                .firstName("Pierre")
                .lastName("Paul")
                //.courses(List.of(courseA,courseB))
                .build();

        teacherRepository.save(teacher);
    }
}