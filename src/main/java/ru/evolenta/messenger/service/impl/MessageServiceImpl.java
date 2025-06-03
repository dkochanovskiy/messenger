package ru.evolenta.messenger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evolenta.messenger.dto.Message;
import ru.evolenta.messenger.repository.MessageRepository;
import ru.evolenta.messenger.service.MessageService;

import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository repository;

    @Override
    public Message addMessage(Message message) {

        repository.save(message);

        return message;
    }

    @Override
    public Iterable<Message> getMessage() {

        return repository.findAll();
    }

    @Override
    public Optional<Message> findMessageById(int id) {

        return repository.findById(id);
    }

    @Override
    public void updateMessage(int id, Message message) {

        repository.updateMessage(id, message.getTitle(), message.getText(), message.getTime());
    }

    @Override
    public void deleteMessage(int id) {

        repository.deleteById(id);
    }
}
