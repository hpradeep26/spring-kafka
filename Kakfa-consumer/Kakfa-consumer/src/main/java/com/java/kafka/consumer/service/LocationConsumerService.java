package com.java.kafka.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.kafka.consumer.model.DriverLocation;

@Service
public class LocationConsumerService {
	
	  @Autowired
	  private ObjectMapper objectMapper;
	
	Logger logger = LoggerFactory.getLogger(LocationConsumerService.class);
	
	@KafkaListener(topics = "${kafka.topic.driver-location}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(ConsumerRecord<String,String> record) throws Exception {
		logger.debug("record = {} ", record);
		String key = record.key();
		 System.out.println("   key: " + key);
		String value = record.value();
		DriverLocation location = objectMapper.readValue(value, DriverLocation.class);
		  System.out.println(" Location update received for driver " + location.getDriverId());
          System.out.println("   Coordinates: " + location.getLatitude() + ", " + location.getLongtitude());
          System.out.println("   Time: " + location.getTimeStamp());
	}
}
