package com.mykafkaproject.consumer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mykafkaproject.consumer.model.Log;
import com.mykafkaproject.consumer.service.KafkaLogListenerService;
import com.mykafkaproject.consumer.service.LogService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaLogListenerServiceImpl implements KafkaLogListenerService {

    private final LogService logService;
    private final ObjectMapper objectMapper;

    public KafkaLogListenerServiceImpl(LogService logService, ObjectMapper objectMapper) {
        this.logService = logService;
        this.objectMapper = objectMapper;
    }

    @Override
    @KafkaListener(topics = "ExampleTopic", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Log message ---> " + message);
        try {
            Log log = objectMapper.readValue(message, Log.class);
            logService.save(log);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("denedim...");
    }

}