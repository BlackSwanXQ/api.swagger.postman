package com.example.api.swagger.postman.service;

import com.example.api.swagger.postman.interfaces.FacultyService;
import com.example.api.swagger.postman.model.Faculty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<Long,Faculty>();
    private long lastId = 0;

        @Override
        public Faculty createFaculty(Faculty faculty) {
            faculty.setId(++lastId);
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }

        @Override
        public ResponseEntity<Faculty> findFacultytById(long userId) {
            if (!faculties.containsKey(userId)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(faculties.get(userId));
        }

        @Override
        public ResponseEntity<Faculty> editFaculty(Faculty faculty) {
            if (!faculties.containsKey(faculty.getId())) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            }
            return ResponseEntity.ok(faculties.put(faculty.getId(), faculty));
        }

        @Override
        public ResponseEntity<Faculty> deleteFaculty(long userId) {
            if (!faculties.containsKey(userId)) {
                return ResponseEntity.status(HttpStatus.MULTI_STATUS).build();
            }
            return ResponseEntity.ok(faculties.remove(userId));
        }

        @Override
        public Collection<Faculty> getAllFaculty() {
            return faculties.values();
        }

        @Override
        public Collection<Faculty> getColorFaculty(String color) {
            return faculties.values().stream()
                    .filter(faculty -> Objects.equals(color, faculty.getColor()))
                    .collect(Collectors.toList());

        }
    }

