package com.dmb.SpringJpaCourse.repository;

import com.dmb.SpringJpaCourse.entity.Course;
import com.dmb.SpringJpaCourse.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
