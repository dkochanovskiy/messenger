package ru.evolenta.messenger.repository;

import org.springframework.data.repository.CrudRepository;
import ru.evolenta.messenger.dto.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {
}
