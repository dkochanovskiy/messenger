package ru.evolenta.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.messenger.dto.Message;
import ru.evolenta.messenger.service.MessageService;

import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    /*
     *  Добавление сообщения
     */
    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {

        return messageService.addMessage(message);
    }

    /*
     *  Поиск всех сообщений
     */
    @GetMapping("/message")
    public Iterable<Message> getMessage() {

        return messageService.getMessage();
    }

    /*
    *  Поиск одного сообщения
    */
    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {

        return messageService.findMessageById(id);
    }

    /*
     *  Изменение одного сообщения
     */
    @PutMapping("/message/{id}")
    public void updateMessage(@PathVariable int id, @RequestBody Message message) {

        messageService.updateMessage(id, message);
    }

    /*
     *  Удаление конкретного сообщения
     */
    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {

        messageService.deleteMessage(id);
    }
}
