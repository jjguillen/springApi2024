package com.example.apiejemplo.services;

import com.example.apiejemplo.entities.Department;
import com.example.apiejemplo.repositories.DepartmentRepository;
import com.example.apiejemplo.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository repository;

    @Override
    public List<Department> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Department> findById(Long id) {
        Objects.requireNonNull(id);
        return this.repository.findById(id);
    }

    @Override
    public Department save(Department department) {
        Objects.requireNonNull(department);
        return this.repository.save(department);
    }

    @Override
    public void deleteById(Long id) {
        Objects.requireNonNull(id);
        this.repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }
}
