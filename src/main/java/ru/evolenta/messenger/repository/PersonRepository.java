package ru.evolenta.messenger.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.evolenta.messenger.dto.Message;
import ru.evolenta.messenger.dto.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Person p SET p.firstname = :firstname, p.surname = :surname, p.lastname = :lastname, p.birthday = :birthday WHERE p.id = :id")
    void updatePerson(@Param("id") Integer id,
                       @Param("title") String firstname,
                       @Param("text") String surname,
                       @Param("time") String lastname,
                       @Param("time") LocalDate birthday);

    @Query("SELECT p.messages FROM Person p WHERE p.id = :id")
    List<Message> getMessagesForPerson(@Param("id") int id);

    @Query("SELECT m FROM Person p JOIN p.messages m WHERE p.id = :personId AND m.id = :messageId")
    Optional<Message> getMessageByIdForPerson(@Param("personId") int personId, @Param("messageId") int messageId);
}
