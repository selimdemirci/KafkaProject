package com.mykafkaproject.producer.service;

import com.mykafkaproject.producer.dto.LogRequest;

public interface KafkaLogService {

    public LogRequest createRandomLogRequest();

    public LogRequest send();

}