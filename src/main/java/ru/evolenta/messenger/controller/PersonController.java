package ru.evolenta.messenger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.messenger.dto.Person;

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

    /*
     *  Добавление объекта Person
     */
    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {

        persons.add(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    /*
     *  Возврат списка объектов Person
     */
    @GetMapping("/person")
    public Iterable<Person> getPersons() {
        return persons;
    }

    /*
     *  Возврат объекта Person по id
     */
    @GetMapping("/person/{id}")
    public Optional<Person> getPersonById(@PathVariable int id) {

        return persons.stream().filter(p -> p.getId() == id).findFirst();
    }

    /*
     *  Изменение объекта Person по id
     */
    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person) {
        int index = - 1;
        for (Person m : persons) {
            if (m.getId() == id) {
                index = persons.indexOf(m);
                persons.set(index, person);
            }
        }
        return index == -1 ? addPerson(person).getBody() : person;
    }

    /*
     *  Удаление объекта Person по id
     */
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {
        persons.removeIf(p -> p.getId() == id);
    }
}
