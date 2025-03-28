package ru.evolenta.messenger.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.evolenta.messenger.dto.Person;

import java.util.Optional;

public interface PersonService {

    public Person addPerson(@RequestBody Person person);
    public Iterable<Person> getPerson();
    public Optional<Person> findPersonById(@PathVariable int id);
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person);
    public void deletePerson(@PathVariable int id);

//    GET /person/{p_id}/message - Возврат списка сообщений Message для объекта Person по p_id
//    GET /person/{p_id}/message/{m_id} - Возврат сообщения Message с m_id для объекта Person по p_id
//    POST /person/{p_id}/message - Добавление сообщения Message в объект Person с p_id
//    DELETE /person/{p_id}/message/{m_id} - Удаление сообщения Message с m_id из объекта Person с p_id
}
