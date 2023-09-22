package com.example.demo.services.interfaces;

import com.example.demo.entity.Person;

import java.util.List;

public interface IPersona {
    public List<Person> traeteTodos();

    public void guardamelo(Person person);

    public void eliminalo(Long id);

    public Person actualizalo(Person person);

}
