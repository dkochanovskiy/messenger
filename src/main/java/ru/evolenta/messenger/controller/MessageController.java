package ru.evolenta.messenger.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.messenger.dto.Message;
import ru.evolenta.messenger.repository.MessageRepository;
import ru.evolenta.messenger.service.MessageService;

import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    /*
     *  Добавление объекта Message
     */
    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {

        return messageService.addMessage(message);
    }

    /*
     *  Возврат списка объектов Message
     */
    @GetMapping("/message")
    public Iterable<Message> getMessage() {

        return  messageService.getMessage();
    }

    /*
    *  Возврат объекта Message по id
    */
    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {

        return  messageService.findMessageById(id);
    }

    /*
     *  Изменение объекта Message по id
     */
    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {

        return new ResponseEntity<>(messageService.updateMessage(id, message).getStatusCode());
    }

    /*
     *  Удаление объекта Message по id
     */
    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {

        messageService.deleteMessage(id);
    }
}
