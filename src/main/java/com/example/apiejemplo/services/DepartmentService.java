package com.example.apiejemplo.services;

import com.example.apiejemplo.entities.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    //RETRIEVE
    List<Department> findAll();
    Optional<Department> findById(Long id);

    //CREATE - UPDATE
    Department save(Department department);

    //DELETE
    void deleteById(Long id);
    void deleteAll();

    //MÁS OPERACIONES
    //...
}
