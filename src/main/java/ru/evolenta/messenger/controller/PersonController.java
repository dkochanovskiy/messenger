package ru.evolenta.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.messenger.dto.Person;
import ru.evolenta.messenger.repository.PersonRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person(1, "Ivan", "Ivanovich", "Ivanov", LocalDate.of(1999, 2,3)),
            new Person(2, "Петр", "Петрович", "Петров", LocalDate.of(2002, 2,2)),
            new Person(3, "Евгений", "Васильевич", "Васин", LocalDate.of(2005, 4,8)),
            new Person(4, "Максим", "Яковлевич", "Окопский", LocalDate.of(1978, 6,5))
    ));

    @Autowired
    private PersonRepository repository;

    /*
     *  Добавление объекта Person
     */
    @PostMapping("/person")
    public ResponseEntity<Person> setPerson(@RequestBody Person person) {

        persons.add(person);

        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    /*
     *  Возврат списка объектов Person
     */
    @GetMapping("/person")
    public Iterable<Person> getPersons() {

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
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {

        HttpStatus status = repository.existsById(id) ? HttpStatus.OK : HttpStatus.CREATED;

        return new ResponseEntity(repository.save(person), status);
    }

    /*
     *  Удаление объекта Person по id
     */
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {

        repository.deleteById(id);
    }
}
