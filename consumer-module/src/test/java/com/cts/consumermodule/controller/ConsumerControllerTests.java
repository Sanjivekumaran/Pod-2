package com.cts.consumermodule.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.consumermodule.repository.ConsumerRepository;
import com.cts.consumermodule.request.ConsumerBusinessRequest;
import com.cts.consumermodule.service.ConsumerService;

@WebMvcTest(value=ConsumerController.class)
public class ConsumerControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ConsumerService consumerService;
	
	@MockBean
	private ConsumerRepository consumerRepository;

//	@Test
//	public void createConsumerBusinessTest() throws Exception {
//
//		ResponseEntity<?> response = ResponseEntity.ok("Created");
//		Mockito.when(consumerService.createConsumerBusiness(Mockito.any(ConsumerBusinessRequest.class)))
//					.thenReturn(response );
//		
//		String exampleCourseJson = "{\r\n"
//				+ "    \"firstName\" : \"Mahi\",\r\n"
//				+ "    \"lastName\" : \"Rocky\",\r\n"
//				+ "    \"dob\" : \"10-05-1999\",\r\n"
//				+ "    \"email\" : \"Mahi753@gmail.com\",\r\n"
//				+ "    \"pan\" : \"CDHKDU9820\",\r\n"
//				+ "    \"businessName\" : \"Mahi Enterprises\",\r\n"
//				+ "    \"businessType\" : \"Retail\",\r\n"
//				+ "    \"businessAge\" : 3,\r\n"
//				+ "    \"capitalInvested\" : 700000,\r\n"
//				+ "    \"businessTurnover\" : 2000000,\r\n"
//				+ "    \"totalEmployees\" : 50,\r\n"
//				+ "    \"validity\" : \"75\",\r\n"
//				+ "    \"agentName\" : \"Ravi\",\r\n"
//				+ "    \"agentId\" : 786\r\n"
//				+ "}" ;
//		
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/createConsumerBusiness")
//				.accept(MediaType.APPLICATION_JSON)
//				.content(exampleCourseJson)
//				.contentType(MediaType.APPLICATION_JSON);
//		
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		
//		String expected = "Created";
//		assertEquals(expected, result.getResponse().getContentAsString());
//		
//
//	}

}
