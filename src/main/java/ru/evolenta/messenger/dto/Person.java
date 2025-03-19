package ru.evolenta.messenger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Person {

    private int id;
    private String firstname;
    private String surname;
    private String lastname;
    private LocalDate birthday;
}
