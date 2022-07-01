package com.cts.consumermodule.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.consumermodule.request.BusinessInputRequest;
import com.cts.consumermodule.request.BusinessUpdateRequest;
import com.cts.consumermodule.request.InputRequest;
import com.cts.consumermodule.request.UpdateRequest;
import com.cts.consumermodule.service.ConsumerService;

@RestController
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	
	@PostMapping("/createConsumerBusiness")
	public String createConsumerBusiness(@Valid @RequestBody InputRequest inputRequest) {
		return consumerService.createConsumerBusiness(inputRequest);
	}
	
	@PostMapping("/updateConsumerBusiness")
	public String updateConsumerBusiness(@Valid @RequestBody UpdateRequest updateRequest) {
		return consumerService.updateConsumerBusiness(updateRequest);
	}
	
	@PostMapping("/createBusinessProperty")
	public String createBusinessProperty(@Valid @RequestBody BusinessInputRequest inputRequest) {
		return consumerService.createBusinessProperty(inputRequest);
	}
	
	@PostMapping("updateBusinessProperty")
	public String updateBusinessProperty(@Valid @RequestBody BusinessUpdateRequest updateRequest) {
		return consumerService.updateBusinessProperty(updateRequest);
	}
}
