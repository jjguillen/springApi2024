package com.example.apiejemplo.services;

import com.example.apiejemplo.entities.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManufacturerService {
    List<Manufacturer> findAll();
    List<Manufacturer> findAllByYear();


}
