package com.springboot.hibernatejpa.dao;

import com.springboot.hibernatejpa.entity.Course;
import com.springboot.hibernatejpa.entity.Instructor;
import com.springboot.hibernatejpa.entity.InstructorDetail;
import com.springboot.hibernatejpa.entity.Student;

import java.util.List;

public interface InstructorDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructor(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetail(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void updateInstructor(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(int id);

    void deleteInstructorById(int id);

    void deleteCourseById(int id);

    void saveCourse(Course course);

    Course findCourseAndReviewByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void updateStudent(Student student);

    void deleteStudentById(int id);

}
