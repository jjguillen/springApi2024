package com.example.apiejemplo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "deparments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int planta;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_manufacturer"))
    @JsonIgnore
    private Manufacturer manufacturer;
}
