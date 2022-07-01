package com.cts.consumermodule.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.consumermodule.exception.ConsumerBusinessNotFoundException;
import com.cts.consumermodule.model.Business;
import com.cts.consumermodule.model.Consumer;
import com.cts.consumermodule.repository.BusinessRepository;
import com.cts.consumermodule.repository.ConsumerRepository;
import com.cts.consumermodule.request.ConsumerBusinessRequest;
import com.cts.consumermodule.response.ConsumerBusinessResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {
	
	//private Logger log = LoggerFactory.getLogger(ConsumerService.class);
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private BusinessRepository businessRepository;
	
	public String createConsumerBusiness(ConsumerBusinessRequest inputRequest) {
		
		Consumer consumer = new Consumer(inputRequest.getFirstName(),inputRequest.getLastName(),
				inputRequest.getDob(),inputRequest.getEmail(),inputRequest.getPan(),inputRequest.getBusinessName(),
				inputRequest.getValidity(),inputRequest.getAgentName(),inputRequest.getAgentId());
		Consumer consumerSavedObj = consumerRepository.save(consumer);
		
		//log.debug("Consumer Obj {}", consumerSavedObj);
		
		Business business = new Business(consumerSavedObj.getId(),inputRequest.getBusinessName(),inputRequest.getBusinessType(),
				inputRequest.getBusinessAge(),inputRequest.getTotalEmployees(),inputRequest.getCapitalInvested(),
				inputRequest.getBusinessTurnover());
		Business businessSavedObj = businessRepository.save(business);
		
		//log.debug("Business Obj {}", businessSavedObj);
		
		return "Success";
		
		
	}
	
	public ConsumerBusinessResponse viewConsumerBusiness(Long consumerid) throws ConsumerBusinessNotFoundException {
		log.info("Start viewConsumerBusinessService");
		Optional<Consumer> consumer = Optional.ofNullable(consumerRepository.findById(consumerid).orElseThrow(() -> new ConsumerBusinessNotFoundException()));
		log.debug("Consumer List : {}", consumer);
		Consumer consumers = consumer.get();
		log.debug("Consumer : {}", consumers);
		Business business = businessRepository.findByConsumerId(consumerid);
		log.debug("Business : {}", business);
		ConsumerBusinessResponse consumerBusinessDetails = new ConsumerBusinessResponse(consumers.getFirstName(),consumers.getLastName(),
				consumers.getDob(),consumers.getEmail(),consumers.getPan(),consumers.getBusinessName(),
				consumers.getValidity(),consumers.getAgentName(),consumers.getAgentId(),business.getConsumerId(),
				business.getBusinessType(),business.getBusinessAge(),business.getTotalEmployees(),business.getCapitalInvested(),
				business.getBusinessTurnover());
		log.debug("ConsumerBusinessDetails : {}", consumerBusinessDetails);
		log.info("End viewConsumerBusinessService");
		return consumerBusinessDetails;

	}
	
	
	
	

}
