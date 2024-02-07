package com.example.apiejemplo.services;

import com.example.apiejemplo.entities.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    //RETRIEVE
    List<Manufacturer> findAll();
    Page<Manufacturer> findAll(Pageable pageable);
    Page<Manufacturer> findAllByYear(Integer year, Pageable pageable);
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> findByName(String name);

    //CREATE - UPDATE
    Manufacturer save(Manufacturer manufacturer);

    //DELETE
    void deleteById(Long id);
    void deleteAll();

    //MÁS OPERACIONES

}
