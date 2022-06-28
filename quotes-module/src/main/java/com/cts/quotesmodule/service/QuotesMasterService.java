package com.cts.quotesmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.quotesmodule.repository.QuotesRepository;

@Service
public class QuotesMasterService {
	@Autowired
	private QuotesRepository quotesRepository;
	
	
}
