package ru.evolenta.messenger.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.evolenta.messenger.dto.Message;

import java.util.Optional;

public interface MessageService {

    public Message addMessage(@RequestBody Message message);
    public Iterable<Message> getMessage();
    public Optional<Message> findMessageById(@PathVariable int id);
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message);
    public void deleteMessage(@PathVariable int id);
}
