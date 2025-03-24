package ru.evolenta.messenger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.messenger.dto.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    private final List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1, "Monday", "Monday is the first day of the week", LocalDateTime.now()),
            new Message(2, "Wednesday", "Monday is the third day of the week", LocalDateTime.now()),
            new Message(3, "Friday", "Monday is the fifth day of the week", LocalDateTime.now())
    ));

    /*
     *  Добавление объекта Message
     */
    @PostMapping("/message")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {

        messages.add(message);

        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    /*
     *  Возврат списка объектов Message
     */
    @GetMapping("/message")
    public Iterable<Message> getMessage() {

        return messages;
    }

    /*
    *  Возврат объекта Message по id
    */
    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {

        return messages.stream().filter(p -> p.getId() == id).findFirst();
    }

    /*
     *  Изменение объекта Message по id
     */
    @PutMapping("/message/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message message) {

        deleteMessage(id);

        Message newMessage = new Message();

        newMessage.setId(id);
        newMessage.setTitle(message.getTitle());
        newMessage.setText(message.getText());
        newMessage.setTime(message.getTime());

        messages.add(newMessage);

        return newMessage;
    }

    /*
     *  Удаление объекта Message по id
     */
    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {

        messages.removeIf(m -> m.getId() == id);
    }
}
