package com.example.apiejemplo.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "num_employees")
    private Integer numEmployees;



}
