package com.java.kafka.publisher.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.kafka.publisher.model.DriverLocation;
import com.java.kafka.publisher.service.LocationPublisherService;

@RestController
public class LocationController {
	
	Logger logger = LoggerFactory.getLogger(LocationController.class);

	private LocationPublisherService locationPublisherService;
	
	public LocationController(LocationPublisherService locationPublisherService) {
		this.locationPublisherService = locationPublisherService;
	}

	@PostMapping("/updateLocation")
	public String updateLocation(@RequestBody DriverLocation driverLocation) {
		logger.debug("driverLocation = {}",driverLocation);
		locationPublisherService.publishLocation(driverLocation);
		return "Location Updated Successfully";
	}
}
