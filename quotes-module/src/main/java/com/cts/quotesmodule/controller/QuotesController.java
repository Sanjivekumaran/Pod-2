package com.cts.quotesmodule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotesController {

	//params int businessType, int  propertyValue, String propertyType
	//returns String quote
	
	@GetMapping("/getQuotesForPolicy")
	public String getQuotes() {
		return "Quote";
	}
}
