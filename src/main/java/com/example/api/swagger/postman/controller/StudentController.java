package com.example.api.swagger.postman.controller;

import com.example.api.swagger.postman.interfaces.StudentService;
import com.example.api.swagger.postman.model.Student;
import jakarta.servlet.MultipartConfigElement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("{userId}")
    public ResponseEntity<Student> findStudentById(@PathVariable long userId) {
        return studentService.findStudentById(userId);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long userId) {
        return studentService.deleteStudent(userId);
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getStudents() {
       return ResponseEntity.ok(studentService.getAllStudents());
    }
     @GetMapping(value="/age",params = {"age"})
    public ResponseEntity<Collection<Student>> getStudentAge(@RequestParam int age) {
        return ResponseEntity.ok(studentService.getAgeStudents(age));
     }

}
