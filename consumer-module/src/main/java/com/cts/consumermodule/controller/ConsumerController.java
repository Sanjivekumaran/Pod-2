package com.cts.consumermodule.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.consumermodule.model.Property;
import com.cts.consumermodule.repository.BusinessRepository;
import com.cts.consumermodule.repository.ConsumerRepository;
import com.cts.consumermodule.repository.PropertyRepository;
import com.cts.consumermodule.request.ConsumerBusinessRequest;
import com.cts.consumermodule.response.ConsumerBusinessResponse;
import com.cts.consumermodule.service.ConsumerService;

@RestController
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@PostMapping("/createConsumerBusiness")
	public String createConsumerBusiness(@RequestBody ConsumerBusinessRequest inputRequest) {
		return consumerService.createConsumerBusiness(inputRequest);
	}
	
	@GetMapping("/viewConsumerBusiness")
	public ResponseEntity<?> viewConsumerBusinessResponse(@RequestParam Long consumerId){
		if (!consumerRepository.existsById(consumerId)) {
			return ResponseEntity.badRequest().body("No Consumer Found!!");
		}
		if (businessRepository.findByConsumerId(consumerId)==null) {
			return ResponseEntity.badRequest().body("No Business Found!!");
		}
		ConsumerBusinessResponse consumerBusinessDetails = consumerService.viewConsumerBusiness(consumerId);
		
		return ResponseEntity.ok(consumerBusinessDetails);
	}
	
	@GetMapping("/viewConsumerProperty")
	public ResponseEntity<?> viewConsumerProperty(@Valid @RequestParam Long consumerId, @RequestParam Long propertyId){
		
		if (!propertyRepository.existsById(propertyId)) {
			return ResponseEntity.badRequest().body("No Property Found!!");
		}
		if (!consumerRepository.existsById(consumerId)) {
			return ResponseEntity.badRequest().body("No Consumer Found!!");
		}
		if (businessRepository.findByConsumerId(consumerId)==null) {
			return ResponseEntity.badRequest().body("No Business Found!!");
		}
		Optional<Property> property = propertyRepository.findById(propertyId);
		return ResponseEntity.ok(property);
		
	}
}
