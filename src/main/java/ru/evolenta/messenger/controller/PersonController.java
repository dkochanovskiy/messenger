package ru.evolenta.messenger.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.messenger.dto.Person;
import ru.evolenta.messenger.service.PersonService;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    /*
     *  Добавление объекта Person
     */
    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {

        personService.addPerson(person);

        return person;
    }

    /*
     *  Возврат списка объектов Person
     */
    @GetMapping("/person")
    public Iterable<Person> getPerson() {

        return personService.getPerson();
    }

    /*
     *  Возврат объекта Person по id
     */
    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {

        return personService.findPersonById(id);
    }

    /*
     *  Изменение объекта Person по id
     */
    @Transactional
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {

        return personService.updatePerson(id, person);
    }

    /*
     *  Удаление объекта Person по id
     */
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {

        personService.deletePerson(id);
    }
}
