package com.example.springmongo.service;

import java.util.List;

import com.example.springmongo.model.Student;

public interface StudentService {
    List<Student> findByName(String name);

    Student findById(String id);

    List<Student> findAllStudents();

    Student createStudent(Student student);

    void addCourseByName(Student student);
}
