package com.cts.consumermodule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.consumermodule.model.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Long>{
	
	Optional<Consumer> findById(Long consumerId);

}
