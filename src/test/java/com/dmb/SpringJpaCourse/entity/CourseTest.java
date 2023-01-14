package com.dmb.SpringJpaCourse.entity;

import com.dmb.SpringJpaCourse.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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


    @Test
    public void findAllPagination(){
        /*
        Pageable firstPagewithThreeRecords= PageRequest.of(0,3);
        Pageable secondPagewithTwoRecords= (Pageable) PageRequest.of(1,2);

        List<Course> courses=courseRepository.findAll().getContent();

        Long totalElements=courseRepository.findAll(firstPagewithThreeRecords).getTotalElements();
        Long totalPages=courseRepository.findAll(firstPagewithThreeRecords).getTotalPages();


        System.out.println("courses = "+totalElements);
        System.out.println("courses = "+courses);

        */
    }

    @Test
    public void findAllSorting(){
        /*
        Pageable sortBytitle=
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );
        Pageable sortByCreditDesc=
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title").descending()
                );

       */
    }

    @Test
    public void findByTitleContaining(){
        Pageable firstPageTenRecords=PageRequest.of(0,10);
        List<Course> courses=courseRepository.findByTitleContaining(
                "P",
                firstPageTenRecords
        ).getContent();

        System.out.println("courses = "+courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("Kool")
                .lastName("Senior")
                .build();
        Student student=Student.builder()
                .firstName("Papy")
                .lastName("Test")
                .emailId("papy@hm.com")
                .build();

        Course course=Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudent(student);
        courseRepository.save(course);
    }


}