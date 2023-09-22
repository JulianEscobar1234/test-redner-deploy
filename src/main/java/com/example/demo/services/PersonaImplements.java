package com.example.demo.services;

import com.example.demo.entity.Person;
import com.example.demo.repos.PersonRepo;
import com.example.demo.services.interfaces.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaImplements implements IPersona {

    @Autowired
    PersonRepo personRepo;

    @Override
    @Transactional
    public List<Person> traeteTodos() {
        return personRepo.findAll();
    }

    @Override
    @Transactional
    public void guardamelo(Person person) {
        personRepo.save(person);
    }

    @Override
    @Transactional
    public void eliminalo(Long id) {
        personRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Person actualizalo(Person person) {
        return personRepo.save(person);
    }
}
