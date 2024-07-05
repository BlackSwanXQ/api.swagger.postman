package com.example.api.swagger.postman.interfaces;

import com.example.api.swagger.postman.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface StudentService {
    public Student createStudent(Student student);
    public ResponseEntity<Student> findStudentById(long userId);
    public ResponseEntity<Student> editStudent(Student student);
    public ResponseEntity<Student> deleteStudent(long userId);
    public Collection<Student> getAllStudents();
    public Collection<Student> getAgeStudents(int age);

}
