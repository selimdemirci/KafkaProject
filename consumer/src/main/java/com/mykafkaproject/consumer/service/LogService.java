package com.mykafkaproject.consumer.service;

import java.util.List;

import com.mykafkaproject.consumer.model.Log;

public interface LogService {

    void save(Log log);

    List<Log> getAll();
}