package com.example.apiejemplo.controllers;

import com.example.apiejemplo.entities.Manufacturer;
import com.example.apiejemplo.repositories.ManufacturerRepository;
import com.example.apiejemplo.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ManufacturerController {

    @Autowired
    private ManufacturerService service;

    @Autowired
    private ManufacturerRepository repository;

    //Un método por cada url de la API relacionada con Manufacturer

    /*  GET - http://localhost:8080/api/manufacturers  */
    @GetMapping("/manufacturers")
    public ResponseEntity<List<Manufacturer>> findAll() {
        List<Manufacturer> manufacturers = this.service.findAll();
        if (manufacturers.isEmpty())
            return ResponseEntity.notFound().build();  //Devuelve 404 si no hay nada

        return ResponseEntity.ok( manufacturers );     //Devuelve 200 y los manufacturers si hay algo
    }

    /*  GET - http://localhost:8080/api/manufacturers/year/2023  */
    @GetMapping("/manufacturers/year/{year}/paginado")
    public ResponseEntity<List<Manufacturer>> findAllByYear(@PathVariable Integer year, @RequestParam(defaultValue = "0") Integer page) {
        var pageable = PageRequest.of(page, 3);
        Page<Manufacturer> manufacturerPage = this.service.findAllByYear(year, pageable);
        return ResponseEntity.ok(manufacturerPage.getContent());
    }

    /*  GET - http://localhost:8080/api/manufacturers/2  */
    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable Long id) {
        return this.service.findById(id)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/manufacturers")
    public ResponseEntity<Manufacturer> create(@RequestBody Manufacturer manufacturer) {
        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }

    @PutMapping("/manufacturers")
    public ResponseEntity<Manufacturer> update(@RequestBody Manufacturer manufacturer) {
        this.service.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }

    /*  DELETE - http://localhost:8080/api/manufacturers/2  */
    @DeleteMapping("/manufacturers/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return this.service.findById(id)
                .map( m -> {
                            this.service.deleteById(id);
                            return ResponseEntity.noContent().build();
                        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    //PAGINACIÓN
    /*  GET - http://localhost:8080/api/manufacturers  */
    @GetMapping("/manufacturers/paginado")
    public ResponseEntity<Map<String, Object>> findAllPaginado(@RequestParam(defaultValue = "0") Integer page) {
        var pageable = PageRequest.of(page, 3);
        Page<Manufacturer> manufacturerPage = this.service.findAll(pageable);
        var pageInfo = Map.of(
                "manufacturers" , manufacturerPage.getContent(),
                "currentPage", manufacturerPage.getNumber(),
                "totalItems", manufacturerPage.getTotalElements(),
                "totalPages", manufacturerPage.getTotalPages()
        );
        return ResponseEntity.ok(pageInfo);
    }


}
