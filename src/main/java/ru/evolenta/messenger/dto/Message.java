package ru.evolenta.messenger.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message {

    @Id
    private int id;
    private String title;
    private String text;
    private LocalDateTime time;

    public Message(String title, String text, LocalDateTime time) {
        this.title = title;
        this.text = text;
        this.time = time;
    }
}
