package com.example.apiejemplo.repositories;

import com.example.apiejemplo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
