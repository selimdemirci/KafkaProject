package com.mykafkaproject.producer.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.mykafkaproject.producer.enums.LogLevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogRequest implements Serializable {

    private static final long serialVersionUID = -3501389024383008971L;

    private LocalDate date;
    private LogLevel level;
    private String message;

}