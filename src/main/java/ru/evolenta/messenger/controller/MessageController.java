package ru.evolenta.messenger.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.messenger.dto.Message;
import ru.evolenta.messenger.repository.MessageRepository;

import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository repository;

    /*
     *  Добавление объекта Message
     */
    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {

        repository.save(message);

        return message;
    }

    /*
     *  Возврат списка объектов Message
     */
    @GetMapping("/message")
    public Iterable<Message> getMessage() {

        return repository.findAll();
    }

    /*
    *  Возврат объекта Message по id
    */
    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {

        return repository.findById(id);
    }

    /*
     *  Изменение объекта Message по id
     */
    @Transactional
    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {

        HttpStatus status = repository.existsById(id) ? HttpStatus.OK : HttpStatus.CREATED;

        repository.deleteById(id);

        Message newMessage = new Message(
                id,
                message.getTitle(),
                message.getText(),
                message.getTime()
        );

        return new ResponseEntity<>(repository.save(newMessage), status);
    }

    /*
     *  Удаление объекта Message по id
     */
    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {

        repository.deleteById(id);
    }
}
