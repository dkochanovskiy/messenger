package ru.evolenta.messenger.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.messenger.dto.Message;
import ru.evolenta.messenger.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    private List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1, "Monday", "Monday is the first day of the week", LocalDateTime.now()),
            new Message(2, "Wednesday", "Monday is the third day of the week", LocalDateTime.now()),
            new Message(3, "Friday", "Monday is the fifth day of the week", LocalDateTime.now())
    ));

    @Autowired
    private MessageRepository repository;

    /*
     *  Добавление объекта Message
     */
    @PostMapping("/person")
    public ResponseEntity<Person> setPerson(@RequestBody Person person) {
        persons.add(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    /*
     *  Возврат списка объектов Message
     */
    @GetMapping("/message")
    public Iterable<Message> getMessages() {
        return repository.findAll();
    }

    /*
    *  Возврат объекта Message по id
    */
    @GetMapping("/message/{id}")
    public Optional<Message> findPersonById(@PathVariable int id) {
        return repository.findById(id);
    }

    /*
     *  Изменение объекта Message по id
     */
    @PutMapping("/message/{id}")
    @Transactional
    public Message updateMessage(@PathVariable int id, @RequestBody Message message) {

        String text = message.getText();
        String title = message.getTitle();
        LocalDateTime time = message.getTime();

//        repository.
        repository.deleteById(id);

        messages.add(text, title, time);
        return null;
    }

    /*
     *  Удаление объекта Message по id
     */
    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        messages.removeIf(p -> p.getId() == id);
    }
}
