package com.cts.quotesmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.quotesmodule.model.QuotesMaster;

public interface QuotesRepository extends JpaRepository<QuotesMaster, Integer>{

}
