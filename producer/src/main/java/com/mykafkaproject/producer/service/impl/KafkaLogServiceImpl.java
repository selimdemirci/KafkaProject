package com.mykafkaproject.producer.service.impl;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import com.mykafkaproject.producer.constants.KafkaServiceBeans;
import com.mykafkaproject.producer.constants.KafkaTopics;
import com.mykafkaproject.producer.dto.LogRequest;
import com.mykafkaproject.producer.enums.LogLevel;
import com.mykafkaproject.producer.service.KafkaLogService;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service(value = KafkaServiceBeans.KAFKA_LOG)
public class KafkaLogServiceImpl implements KafkaLogService {

    private final KafkaTemplate<String, LogRequest> kafkaTemplate;

    public KafkaLogServiceImpl(KafkaTemplate<String, LogRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public LogRequest createRandomLogRequest() {
        Random randomNumber = new Random();
        int index = randomNumber.nextInt(3);
        LogLevel logLevel = LogLevel.values()[index];
        LocalDate date = LocalDate.now();
        return new LogRequest(date, logLevel, "A log just created with ID: " + index);
    }

    @Override
    public LogRequest send() {
        LogRequest logRequest = createRandomLogRequest();
        if (logRequest != null) {
            kafkaTemplate.send(KafkaTopics.EXAMPLE_TOPIC, UUID.randomUUID().toString(), logRequest);
            return logRequest;
        }
        return null;
    }

}