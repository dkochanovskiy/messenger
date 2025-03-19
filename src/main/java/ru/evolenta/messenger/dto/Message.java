package ru.evolenta.messenger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Message {

    private int id;
    private String title;
    private String text;
    private LocalDateTime time;
}
