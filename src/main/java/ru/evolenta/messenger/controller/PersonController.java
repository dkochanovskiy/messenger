package ru.evolenta.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.messenger.dto.Message;
import ru.evolenta.messenger.dto.Person;
import ru.evolenta.messenger.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    /*
     *  Добавление пользователя
     */
    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {

        return personService.addPerson(person);
    }

    /*
     *  Поиск всех пользователей
     */
    @GetMapping("/person")
    public Iterable<Person> getPerson() {

        return personService.getPerson();
    }

    /*
     *  Поиск одного пользователя
     */
    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {

        return personService.findPersonById(id);
    }

    /*
     *  Изменение пользователя
     */
    @PutMapping("/person/{id}")
    public void updatePerson(@PathVariable int id, @RequestBody Person person) {

        personService.updatePerson(id, person);
    }

    /*
     *  Удаление пользователя
     */
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {

        personService.deletePerson(id);
    }

    /*
     *  Вывод всех сообщений для конкретного пользователя
     */
    @GetMapping("/person/{id}/message")
    public List<Message> getMessagesForPerson(@PathVariable int id) {

        return personService.getMessagesForPerson(id);
    }

    /*
     *  Вывод одного сообщения для конкретного пользователя
     */
    @GetMapping("/person/{personId}/message/{messageId}")
    public Optional<Message> getMessageByIdForPerson(@PathVariable int personId, @PathVariable int messageId) {

        return personService.getMessageByIdForPerson(personId, messageId);
    }

    /*
     *  Удаление сообщения у конкретного пользователя
     */
    @DeleteMapping("/person/{personId}/message/{messageId}")
    public void deleteMessageFromPerson(@PathVariable int personId, @PathVariable int messageId) {

        personService.deleteMessageFromPerson(personId, messageId);
    }

    /*
     *  Добавление сообщения конкретному пользователю при существовании пользователя
     */
    @PostMapping("/person/{id}/message")
    public ResponseEntity<?> addMessageToPerson(@PathVariable int id, @RequestBody Message message) {

        return personService.addMessageToPerson(id, message);
    }
}
