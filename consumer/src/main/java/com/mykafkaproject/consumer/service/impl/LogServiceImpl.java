package com.mykafkaproject.consumer.service.impl;

import java.util.List;

import com.mykafkaproject.consumer.model.Log;
import com.mykafkaproject.consumer.repository.LogRepository;
import com.mykafkaproject.consumer.service.LogService;

import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public void save(Log log) {
        logRepository.save(log);
    }

    @Override
    public List<Log> getAll() {
        return logRepository.findAll();
    }

}