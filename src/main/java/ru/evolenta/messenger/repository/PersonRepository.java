package ru.evolenta.messenger.repository;

import org.springframework.data.repository.CrudRepository;
import ru.evolenta.messenger.dto.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
