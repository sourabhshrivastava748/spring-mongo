package com.example.springmongo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.springmongo.model.Student;
import com.example.springmongo.repository.StudentRepository;
import com.example.springmongo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student findById(String id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.isPresent() ? student.get() : new Student();
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void addCourseByName(Student student) {
        Student st = studentRepository.findByName(student.getName()).get(0);
        st.getCourseList().addAll(student.getCourseList());
        studentRepository.save(st);
    }
}
