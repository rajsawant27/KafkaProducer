package com.kafkaImpl.DeliveryBoy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaImpl.DeliveryBoy.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private KafkaService kafkaService;

	@PostMapping("/update")
	public ResponseEntity<?> updateLocation() {

		this.kafkaService.updateLocation(
				"(" + Math.round(Math.random() * 100) + " , " + Math.round(Math.random() * 100) + " " + ")");
		return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);

	}
}
