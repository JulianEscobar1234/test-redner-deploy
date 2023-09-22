package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;


import java.io.Serializable;

@Entity
@Table(name = "persona")
@Data
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id_persona;

    @NotNull
    @Column(name = "nombre")
    private String nombre;


    @NotNull
    @Column(name = "apellido")
    private String apellido;


    @NotNull
    @Column(name = "corre")
    private String correo;

}
