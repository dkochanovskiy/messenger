package ru.evolenta.messenger.service;

import org.springframework.stereotype.Service;
import ru.evolenta.messenger.dto.Message;

import java.util.Optional;

@Service
public interface MessageService {

    Message addMessage(Message message);

    Iterable<Message> getMessage();

    Optional<Message> findMessageById(int id);

    void updateMessage(int id, Message message);

    void deleteMessage(int id);
}
