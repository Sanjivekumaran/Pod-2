package com.cts.consumermodule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.consumermodule.repository.ConsumerRepository;
import com.cts.consumermodule.request.BusinessInputRequest;
import com.cts.consumermodule.request.ConsumerBusinessRequest;

@ExtendWith(MockitoExtension.class)
public class ConsumerServiceTests {
	
	@InjectMocks
	private ConsumerService consumerService;
	
	@MockBean
	private ConsumerRepository consumerRepository;
	
	
	@Test
	public void testCalculatePropertyValue() {
		long result = consumerService.calculatePropertyValue((long)200,(long)20,(long)13);
		assertEquals((long)9,result);
	}
	
	@Test
	public void testCalculateBusinessEligibilitySuccess() {
		
		ConsumerBusinessRequest mockRequest = new ConsumerBusinessRequest("fname", "lname", "email",
				"pan", "dob", "bName", "btype", (long)1, "validity", (long) 1, "agentName", (long) 1, (long) 3, (long) 55);
		
		Boolean result = consumerService.checkBusinessEligibility(mockRequest);
		assertEquals(true,result);
	}
	
	@Test
	public void testCalculateBusinessEligibilityFail() {
		
		ConsumerBusinessRequest mockRequest = new ConsumerBusinessRequest("fname", "lname", "email",
				"pan", "dob", "bName", "btype", (long)1, "validity", (long) 1, "agentName", (long) 1, (long) 1, (long) 1);
		
		Boolean result = consumerService.checkBusinessEligibility(mockRequest);
		assertEquals(false,result);
	}
	
	@Test 
	public void testCalculatePropertyEligibilitySuccess() {
		
		BusinessInputRequest mockRequestforOwn = new BusinessInputRequest((long)1, (long)1, "Bsqft", "own", "bStoreys", (long)6, 
				(long)1, (long)1, (long)1);
		
		BusinessInputRequest mockRequestforRent = new BusinessInputRequest((long)1, (long)1, "Bsqft", "rent", "bStoreys", (long)4, 
				(long)1, (long)1, (long)1);
		
		Boolean resultOwn = consumerService.checkPropertyEligibility(mockRequestforOwn);
		assertEquals(true, resultOwn);
		
		Boolean resultRent = consumerService.checkPropertyEligibility(mockRequestforRent);
		assertEquals(true, resultRent);
		
	}
	
	@Test 
	public void testCalculatePropertyEligibilityFail() {
		
		BusinessInputRequest mockRequestforOwn = new BusinessInputRequest((long)1, (long)1, "Bsqft", "own", "bStoreys", (long)4, 
				(long)1, (long)1, (long)1);
		
		BusinessInputRequest mockRequestforRent = new BusinessInputRequest((long)1, (long)1, "Bsqft", "rent", "bStoreys", (long)1, 
				(long)1, (long)1, (long)1);
		
		Boolean resultOwn = consumerService.checkPropertyEligibility(mockRequestforOwn);
		assertEquals(false, resultOwn);
		
		Boolean resultRent = consumerService.checkPropertyEligibility(mockRequestforRent);
		assertEquals(false, resultRent);
		
	}
	

}
