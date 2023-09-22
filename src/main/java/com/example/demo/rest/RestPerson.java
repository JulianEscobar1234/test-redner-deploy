package com.example.demo.rest;

import com.example.demo.entity.Person;
import com.example.demo.services.interfaces.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class RestPerson {
    @Autowired
    private IPersona iPersona;

    @GetMapping("/listar")
    private ResponseEntity<List<Person>> listarPersonas() {
        return ResponseEntity.ok(iPersona.traeteTodos());
    }

    @PostMapping("/crear")
    private ResponseEntity<Person> guardar(@Validated @RequestBody Person person) {
        try {
            iPersona.guardamelo(person);
            ResponseEntity.status(201);
            return ResponseEntity.ok((person));

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    private ResponseEntity<Void> eliminar(@PathVariable("id") Long id) {
iPersona.eliminalo(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actualizar")
    private ResponseEntity<Person> actualizar(@RequestBody Person person) {
        Person temporal = iPersona.actualizalo(person);
        try {
            return ResponseEntity.created(new URI("/api/colegios" + temporal.getId_persona())).body(temporal);
        } catch (Exception e) {
            System.err.println("Error → " + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
