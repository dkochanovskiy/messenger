package ru.evolenta.messenger.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.evolenta.messenger.dto.Message;
import ru.evolenta.messenger.dto.Person;
import ru.evolenta.messenger.repository.PersonRepository;
import ru.evolenta.messenger.service.PersonService;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public Person addPerson(Person person) {

        repository.save(person);

        return person;
    }

    @Override
    public Iterable<Person> getPerson() {

        return repository.findAll();
    }

    @Override
    public Optional<Person> findPersonById(int id) {

        return repository.findById(id);
    }

    @Override
    public void updatePerson(int id, Person person) {

        repository.updatePerson(id, person.getFirstname(), person.getSurname(), person.getLastname(),
                person.getBirthday());
    }

    @Override
    public void deletePerson(int id) {

        repository.deleteById(id);
    }

    @Override
    public List<Message> getMessagesForPerson(int id) {

        return repository.getMessagesForPerson(id);
    }

    @Override
    public Optional<Message> getMessageByIdForPerson(@PathVariable int personId, @PathVariable int messageId) {

        return repository.getMessageByIdForPerson(personId, messageId);
    }

    @Override
    @Transactional
    public void deleteMessageFromPerson(int personId, int messageId) {

        Person person = repository.findById(personId).orElseThrow();

        person.getMessages().removeIf(m -> m.getId() == messageId);
    }

    @Override
    public ResponseEntity<?> addMessageToPerson(int id, Message message) {

        Optional<Person> personOpt =repository.findById(id);
        if (personOpt.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Пользователь с id " + id + " не найден");
        }

        Person person = personOpt.get();
        Message newMessage = new Message(
                message.getTitle(),
                message.getText(),
                message.getTime()
        );

        person.getMessages().add(newMessage);
        repository.save(person);
        return ResponseEntity.ok("Сообщение успешно добавлено");
    }
}
