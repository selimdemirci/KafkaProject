package com.mykafkaproject.consumer.controller;

import java.util.List;

import com.mykafkaproject.consumer.model.Log;
import com.mykafkaproject.consumer.service.LogService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final LogService logService;

    public ConsumerController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public ResponseEntity<List<Log>> getAll() {
        return new ResponseEntity<>(logService.getAll(), HttpStatus.OK);
    }

}