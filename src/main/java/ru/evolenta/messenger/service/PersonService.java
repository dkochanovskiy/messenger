package ru.evolenta.messenger.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.evolenta.messenger.dto.Message;
import ru.evolenta.messenger.dto.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person addPerson(@RequestBody Person person);

    Iterable<Person> getPerson();

    Optional<Person> findPersonById(int id);

    void updatePerson(@PathVariable int id, @RequestBody Person person);

    void deletePerson(@PathVariable int id);

    List<Message> getMessagesForPerson(int id);

    Optional<Message> getMessageByIdForPerson(int personId, int messageId);

    void deleteMessageFromPerson(int personId, int messageId);

    ResponseEntity<?> addMessageToPerson(int id, Message message);
}
