package com.example.api.swagger.postman.service;

import com.example.api.swagger.postman.interfaces.StudentService;
import com.example.api.swagger.postman.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> students = new HashMap<Long, Student>();
    private long lastId = 0;


    @Override
    public Student createStudent(Student student) {
        student.setId(++lastId);
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public ResponseEntity<Student> findStudentById(long userId) {
        if (!students.containsKey(userId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(students.get(userId));
    }

    @Override
    public ResponseEntity<Student> editStudent(Student student) {
        if (!students.containsKey(student.getId())) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.ok(students.put(student.getId(), student));
    }

    @Override
    public ResponseEntity<Student> deleteStudent(long userId) {
        if (!students.containsKey(userId)) {
            return ResponseEntity.status(HttpStatus.MULTI_STATUS).build();
        }
        return ResponseEntity.ok(students.remove(userId));
    }

    @Override
    public Collection<Student>getAllStudents() {
        return students.values();
    }

    @Override
    public Collection<Student> getAgeStudents(int age) {
       return students.values().stream()
                .filter(student -> age == student.getAge())
                .collect(Collectors.toList());

    }
}
