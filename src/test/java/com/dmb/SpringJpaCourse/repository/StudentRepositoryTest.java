package com.dmb.SpringJpaCourse.repository;

import com.dmb.SpringJpaCourse.entity.Guardian;
import com.dmb.SpringJpaCourse.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("rose@gmail.com")
                .firstName("Rose")
                .lastName("Ngalu")
                //.guardianEmail("dan@gmail.com")
                //.guardianName("Dan")
                //.guardianMobile("0024399")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian=Guardian.builder()
                .name("Bizwa")
                .email("bizwa@gmail.com")
                .mobile("0033")
                .build();

        Student student=Student.builder()
                .emailId("kapi@gmail.com")
                .firstName("Kapi")
                .lastName("Kapso")
                .guardian(guardian)
                //.guardianEmail("dan@gmail.com")
                //.guardianName("Dan")
                //.guardianMobile("0024399")
                .build();
        studentRepository.save(student);
    }


    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students=studentRepository.findByFirstName("kapi");
        System.out.println("Our student : "+students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students=studentRepository.findByFirstNameContaining("a");
        System.out.println("Our student : "+students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students=studentRepository.findByGuardianName("bizwa");
        System.out.println("Our student : "+students);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress(
                "kapi@gmail.com"
        );
        System.out.println("My student : "+student);
    }


    @Test
    public void getStudentFirstNameByEmailAddress(){
        String student=studentRepository.getStudentFirstNameByEmailAddress(
                "kapi@gmail.com"
        );
        System.out.println("My student is : "+student);
    }
}