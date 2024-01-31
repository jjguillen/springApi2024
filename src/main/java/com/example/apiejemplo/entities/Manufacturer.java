package com.example.apiejemplo.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manufacturers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private Integer year;

    @Column(name = "num_employees")  //En la tabla tendrá este nombre
    private Integer numEmployees;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.EAGER)
    private List<Department> departments = new ArrayList<>();



}
