package com.example.apiejemplo.services;

import com.example.apiejemplo.entities.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    //RETRIEVE
    List<Manufacturer> findAll();
    List<Manufacturer> findAllByYear(Integer year);
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> findByName(String name);

    //CREATE - UPDATE
    Manufacturer save(Manufacturer manufacturer);

    //DELETE
    void deleteById(Long id);
    void deleteAll();

    //MÁS OPERACIONES

}
