package ru.evolenta.messenger.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @Id
    private int id;
    private String firstname;
    private String surname;
    private String lastname;
    private LocalDate birthday;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;
}