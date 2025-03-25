package ru.evolenta.messenger.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.messenger.dto.Person;
import ru.evolenta.messenger.repository.PersonRepository;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;

    /*
     *  Добавление объекта Person
     */
    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {

        repository.save(person);

        return person;
    }

    /*
     *  Возврат списка объектов Person
     */
    @GetMapping("/person")
    public Iterable<Person> getPerson() {

        return repository.findAll();
    }

    /*
     *  Возврат объекта Person по id
     */
    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {

        return repository.findById(id);
    }

    /*
     *  Изменение объекта Person по id
     */
    @Transactional
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {

        HttpStatus status = repository.existsById(id) ? HttpStatus.OK : HttpStatus.CREATED;

        repository.deleteById(id);

        Person newPerson = new Person(
                id,
                person.getFirstname(),
                person.getLastname(),
                person.getSurname(),
                person.getBirthday()
        );

        return new ResponseEntity<>(repository.save(newPerson), status);
    }

    /*
     *  Удаление объекта Person по id
     */
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {

        repository.deleteById(id);
    }
}
