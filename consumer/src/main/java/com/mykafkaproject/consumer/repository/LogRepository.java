package com.mykafkaproject.consumer.repository;

import com.mykafkaproject.consumer.model.Log;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {

}