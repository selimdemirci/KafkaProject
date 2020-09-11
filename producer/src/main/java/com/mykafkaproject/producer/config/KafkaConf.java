package com.mykafkaproject.producer.config;

import java.util.HashMap;
import java.util.Map;

import com.mykafkaproject.producer.dto.LogRequest;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaConf {

    @Bean
    public Map<String, Object> producerConf() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return config;
    }

    @Bean
    public ProducerFactory<String, LogRequest> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConf());
    }

    @Bean
    public KafkaTemplate<String, LogRequest> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}