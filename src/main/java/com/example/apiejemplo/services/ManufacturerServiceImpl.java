package com.example.apiejemplo.services;

import com.example.apiejemplo.entities.Manufacturer;
import com.example.apiejemplo.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    ManufacturerRepository repository;

    @Override
    public List<Manufacturer> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Page<Manufacturer> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public Page<Manufacturer> findAllByYear(Integer year, Pageable pageable) {
        Objects.requireNonNull(year); //Salta una excepción si year es null
        return this.repository.findAllByYear(year, pageable);
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        Objects.requireNonNull(id);
        return this.repository.findById(id);
    }

    @Override
    public Optional<Manufacturer> findByName(String name) {
        Objects.requireNonNull(name);
        return this.repository.findByName(name);
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        Objects.requireNonNull(manufacturer);
        return this.repository.save(manufacturer);
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
