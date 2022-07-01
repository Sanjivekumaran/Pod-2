package com.cts.consumermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.consumermodule.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Long> {
	
	Property findByConsumerId(Long consumerId);

}
