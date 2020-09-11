package com.mykafkaproject.consumer.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document
public class Log {

    @Id
    private String id;

    private LocalDate date;
    private String level;
    private String message;

}