package com.example.api.swagger.postman.controller;


import com.example.api.swagger.postman.interfaces.FacultyService;
import com.example.api.swagger.postman.model.Faculty;
import com.example.api.swagger.postman.model.Faculty;
import jakarta.servlet.MultipartConfigElement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("{userId}")
    public ResponseEntity<Faculty>findFacultyById(@PathVariable long userId) {
        return facultyService.findFacultytById(userId);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable long userId) {
        return facultyService.deleteFaculty(userId);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getFaculty() {
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }
    @GetMapping(value="/color",params = {"color"})
    public ResponseEntity<Collection<Faculty>> getFacultyColor(@RequestParam String color) {
        return ResponseEntity.ok(facultyService.getColorFaculty(color));
    }


}
