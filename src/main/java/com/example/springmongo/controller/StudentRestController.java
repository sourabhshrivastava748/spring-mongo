package com.example.springmongo.controller;

import java.util.List;

import com.example.springmongo.dto.StudentDTO;
import com.example.springmongo.model.Student;
import com.example.springmongo.service.StudentService;
import com.example.springmongo.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/")
    public List<StudentDTO> getAllStudents() {
        return ObjectMapperUtils.mapAll(studentService.findAllStudents(), StudentDTO.class);
    }

    @GetMapping(value = "/id/{id}")
    public StudentDTO getStudentById(@PathVariable("id") String id) {
        return ObjectMapperUtils.map(studentService.findById(id), StudentDTO.class);
    }

    @GetMapping(value = "/name/{name}")
    public StudentDTO getStudentByName(@PathVariable("name") String name) {
        return ObjectMapperUtils.map(studentService.findByName(name), StudentDTO.class);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(ObjectMapperUtils.map(studentDTO, Student.class));
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/course/add")
    public ResponseEntity<?> addCourseByName(@RequestBody StudentDTO studentDTO) {
        studentService.addCourseByName(ObjectMapperUtils.map(studentDTO, Student.class));
        return new ResponseEntity("Student course added successfully", HttpStatus.OK);
    }

}
