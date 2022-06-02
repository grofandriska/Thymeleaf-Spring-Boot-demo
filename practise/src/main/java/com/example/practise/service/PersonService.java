package com.example.practise.service;

import com.example.practise.model.Person;
import com.example.practise.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public void add(Person person) {
        repository.save(person);
    }

    public Person get(Long id) {
        return repository.findById(id).get();
    }

    public List<Person> list() {
        return repository.findAll();
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public Person update(Long id, Person person) {
        repository.findById(id).map(object -> {
            object.setName(person.getName());
            object.setAge(person.getAge());
            return repository.save(object);
        });
        return null;
    }
}
