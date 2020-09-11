package com.mykafkaproject.producer.controller;

import com.mykafkaproject.producer.constants.KafkaServiceBeans;
import com.mykafkaproject.producer.dto.LogRequest;
import com.mykafkaproject.producer.service.KafkaLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    @Qualifier(value = KafkaServiceBeans.KAFKA_LOG)
    private KafkaLogService kafkaLogService;

    @PostMapping
    public ResponseEntity<LogRequest> sendLog() {
        return new ResponseEntity<>(kafkaLogService.send(), HttpStatus.CREATED);
    }

}