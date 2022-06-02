package com.example.practise.service;

import com.example.practise.model.Message;
import com.example.practise.model.Person;
import com.example.practise.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository repository;

    public List<Person> list;

    public PersonService(PersonRepository repository, List<Person> list) {
        this.repository = repository;
        this.list = list;
    }

    public Person getPerson(Long id) {
        for (Person person : list) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public void addPerson() {
        Message msg = new Message(1L, "Hello World");
        Message msg2 = new Message(2L, "Hello Asia");
        List<Message> messagesTest = List.of(msg, msg2);
        Person pr = new Person(1L,"Thomas",messagesTest);
        list.add(pr);
    }
}
