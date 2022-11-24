package com.example.springmongo.repository;

import java.util.List;
import java.util.Optional;

import com.example.springmongo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByName(String name);

    Optional<Student> findById(String id);

}
