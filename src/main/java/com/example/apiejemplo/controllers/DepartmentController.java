package com.example.apiejemplo.controllers;

import com.example.apiejemplo.entities.Department;
import com.example.apiejemplo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/deparments")
    public ResponseEntity<List<Department>> findAll() {
        List<Department> deparments = this.departmentService.findAll();
        if (deparments.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(deparments);
        }
    }


}
