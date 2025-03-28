package ru.evolenta.messenger.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.evolenta.messenger.dto.Person;
import ru.evolenta.messenger.repository.PersonRepository;
import ru.evolenta.messenger.service.PersonService;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public Person addPerson(Person person) {

        return repository.save(person);
    }

    @Override
    public Iterable<Person> getPerson() {

        return repository.findAll();
    }

    @Override
    public Optional<Person> findPersonById(int id) {

        return repository.findById(id);
    }

    @Transactional
    @Override
    public ResponseEntity<Person> updatePerson(int id, Person person) {

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

    @Override
    public void deletePerson(int id) {

        repository.deleteById(id);
    }
}
