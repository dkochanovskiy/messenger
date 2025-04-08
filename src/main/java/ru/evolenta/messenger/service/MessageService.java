package ru.evolenta.messenger.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.evolenta.messenger.dto.Message;

import java.util.Optional;

public interface MessageService {

    Message addMessage(@RequestBody Message message);
    Iterable<Message> getMessage();
    Optional<Message> findMessageById(@PathVariable int id);
    ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message);
    void deleteMessage(@PathVariable int id);

    Iterable<Message> getMessageByPersonId();
}
