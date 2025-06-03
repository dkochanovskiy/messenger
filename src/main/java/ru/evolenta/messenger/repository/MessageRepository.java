package ru.evolenta.messenger.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.evolenta.messenger.dto.Message;

import java.time.LocalDateTime;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Message m SET m.title = :title, m.text = :text, m.time =:time WHERE m.id = :id")
    void updateMessage(@Param("id") Integer id,
                    @Param("title") String title,
                    @Param("text") String text,
                    @Param("time") LocalDateTime time);
}
