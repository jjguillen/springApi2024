package com.example.apiejemplo.repositories;

import org.springframework.data.domain.Page;
import com.example.apiejemplo.entities.Manufacturer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

    Page<Manufacturer> findAll(Pageable pageable);

    Page<Manufacturer> findAllByYear(Integer year, Pageable pageable);
    Optional<Manufacturer> findByName(String name);
}
