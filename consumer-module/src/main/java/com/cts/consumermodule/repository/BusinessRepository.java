package com.cts.consumermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.consumermodule.model.Business;

public interface BusinessRepository extends JpaRepository<Business,Long> {
	
	Business findByConsumerId(Long consumerId);

}
