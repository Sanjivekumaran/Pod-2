package com.cts.quotesmodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.quotesmodule.model.QuotesMaster;
import com.cts.quotesmodule.service.QuotesMasterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class QuotesController {

	@Autowired
	private QuotesMasterService quotesMasterService;

	/**
	 * @param businessValue
	 * @param propertyValue
	 * @param propertyType
	 * @return
	 * @throws Exception
	 */

	@GetMapping("/getQuotesForPolicy")
	public String getQuotes(@RequestParam Long businessValue, @RequestParam Long propertyValue,
			@RequestParam String propertyType) {
		String quote = "No Quotes, Contact Insurance Provider";
		log.info("Start");

		try {
			QuotesMaster quoteMaster = quotesMasterService.getQuoteMaster(businessValue, propertyValue, propertyType);
			log.info("QuotesMaster: {}", quoteMaster);
			quote = quoteMaster.getQuote();
		} catch (NullPointerException e) {
			log.info("End");
			return quote;
		}
		log.info("End");
		return quote;
	}

	@GetMapping("/getAllQuotes")
	public List<QuotesMaster> getAllQuotes() {
		log.info("Started getAllQuotes");
		log.info("End getAllQuotes");
		return quotesMasterService.getAllQuotes();
	}

	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		log.info("Working fine");
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}

}
