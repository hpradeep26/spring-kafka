package com.java.kafka.publisher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.kafka.publisher.model.DriverLocation;

@Service
public class LocationPublisherService {

	@Value("${kafka.topic.driver-location}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private final ObjectMapper mapper = new ObjectMapper();

	public void publishLocation(DriverLocation driverLocation) {
		try {
			String key = driverLocation.getDriverId();
			String value = mapper.writeValueAsString(driverLocation);
			kafkaTemplate.send(topic, key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
