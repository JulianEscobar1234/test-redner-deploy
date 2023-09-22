package com.example.demo.utilities;

import com.example.demo.entity.Person;
import com.example.demo.repos.PersonRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultDataLoader {

    @Autowired
    private PersonRepo personRepo;

    @PostConstruct
    public void init() {
        if (personRepo.count() == 0) {

            Person person1 = new Person();
            person1.setNombre("Persona 1");
            person1.setApellido("Apellido 1");
            person1.setCorreo("Correo 1");
            personRepo.save(person1);


            Person person2 = new Person();
            person2.setNombre("Persona 2");
            person2.setApellido("Apellido 2");
            person2.setCorreo("Correo 2");
            personRepo.save(person2);


            Person person3 = new Person();
            person3.setNombre("Persona 3");
            person3.setApellido("Apellido 3");
            person3.setCorreo("Correo 3");
            personRepo.save(person3);
        }
    }

}
