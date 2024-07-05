package com.example.api.swagger.postman.interfaces;

import com.example.api.swagger.postman.model.Faculty;
import com.example.api.swagger.postman.model.Faculty;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface FacultyService{
    public Faculty createFaculty(Faculty faculty);
    public ResponseEntity<Faculty> findFacultytById(long userId);
    public ResponseEntity<Faculty> editFaculty(Faculty faculty);
    public ResponseEntity<Faculty> deleteFaculty(long userId);
    public Collection<Faculty> getAllFaculty();
    public Collection<Faculty> getColorFaculty(String color);

}
