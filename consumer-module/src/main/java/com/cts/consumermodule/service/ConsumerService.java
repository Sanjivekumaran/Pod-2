package com.cts.consumermodule.service;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.consumermodule.model.Business;
import com.cts.consumermodule.model.Consumer;
import com.cts.consumermodule.model.Property;
import com.cts.consumermodule.repository.BusinessRepository;
import com.cts.consumermodule.repository.ConsumerRepository;
import com.cts.consumermodule.repository.PropertyRepository;
import com.cts.consumermodule.request.BusinessInputRequest;
import com.cts.consumermodule.request.BusinessUpdateRequest;
import com.cts.consumermodule.request.InputRequest;
import com.cts.consumermodule.request.UpdateRequest;

@Service
public class ConsumerService {
	
	private Logger log = LoggerFactory.getLogger(ConsumerService.class);
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	
	/*Creating consumer by accepting the inputRequest as RequestBody*/
	public String createConsumerBusiness(InputRequest inputRequest) {
		
		Consumer consumer = new Consumer(inputRequest.getFirstName(),inputRequest.getLastName(),
				inputRequest.getDob(),inputRequest.getEmail(),inputRequest.getPan(),inputRequest.getBusinessName(),
				inputRequest.getValidity(),inputRequest.getAgentName(),inputRequest.getAgentId());
		Consumer consumerSavedObj = consumerRepository.save(consumer);
		
		log.debug("Consumer Obj {}", consumerSavedObj);
		
		Business business = new Business(consumerSavedObj.getId(),inputRequest.getBusinessName(),inputRequest.getBusinessType(),
				inputRequest.getBusinessAge(),inputRequest.getTotalEmployees(),inputRequest.getCapitalInvested(),
				inputRequest.getBusinessTurnover());
		Business businessSavedObj = businessRepository.save(business);
		
		log.debug("Business Obj {}", businessSavedObj);
		
		return "Create Success";
		
	}
	
	/*Updating consumer by accepting the updateRequest as RequestBody*/
	public String updateConsumerBusiness(UpdateRequest updateRequest) {
		
		Optional<Consumer> consumer = consumerRepository.findById(updateRequest.getConsumerId());
		log.debug("{}",consumer.isPresent());
		Consumer consumer_info = consumer.get();
		
		log.debug("Customer Id info {}", consumer_info);
		
		Business business_info = businessRepository.findByConsumerId(updateRequest.getConsumerId());
		
		log.debug("Business Info Obj {}", business_info);
		
		consumer_info.setFirstName(updateRequest.getFirstName());
		consumer_info.setLastName(updateRequest.getLastName());
		consumer_info.setEmail(updateRequest.getEmail());
		consumer_info.setPan(updateRequest.getPan());
		consumer_info.setDob(updateRequest.getDob());
		consumer_info.setBusinessName(updateRequest.getBusinessName());
		consumer_info.setValidity(updateRequest.getValidity());
		consumer_info.setAgentId(updateRequest.getAgentId());
		consumer_info.setAgentName(updateRequest.getAgentName());
		
		Consumer consumerUpdateObj = consumerRepository.save(consumer_info);
		
		business_info.setBusinessType(updateRequest.getBusinessType());
		business_info.setBusinessAge(updateRequest.getBusinessAge());
		business_info.setBusinessTurnover(updateRequest.getBusinessTurnover());
		business_info.setCapitalInvested(updateRequest.getCapitalInvested());
		business_info.setTotalEmployees(updateRequest.getTotalEmployees());
		
		Business businessUpdateObj = businessRepository.save(business_info);
		
		return "Update Success";
	}
	
	/*Creating property by accepting the inputRequest as RequestBody*/
	public String createBusinessProperty(BusinessInputRequest inputRequest) {
		
		Long propertyValue = calculatePropertyValue(inputRequest.getCostOftheAsset(),inputRequest.getSalvageValue(),
				inputRequest.getUsefulLifeofAsset());
		
		Property property = new Property(inputRequest.getBusinessId(),inputRequest.getConsumerId(),inputRequest.getBuildingSqFt(),
				inputRequest.getBuildingType(),inputRequest.getBuildingStoreys(),inputRequest.getBuildingAge(),propertyValue,
				inputRequest.getCostOftheAsset(),inputRequest.getSalvageValue(),inputRequest.getUsefulLifeofAsset());
		
		Property propertySavedObj = propertyRepository.save(property);
		
		log.debug("Property Saved {}", propertySavedObj);
	
		return "Property Created";
		
	}

	/*Updating property by accepting the updateRequest as RequestBody*/
	public String updateBusinessProperty(BusinessUpdateRequest updateRequest) {
		
		Long propertyValue = calculatePropertyValue(updateRequest.getCostOftheAsset(),updateRequest.getSalvageValue(),
				updateRequest.getUsefulLifeofAsset());
		
		Property property = propertyRepository.findByConsumerId(updateRequest.getConsumerId());
		
		property.setBuildingSqFt(updateRequest.getBuildingSqFt());
		property.setBuildingType(updateRequest.getBuildingType());
		property.setBuildingAge(updateRequest.getBuildingAge());
		property.setBuildingStoreys(updateRequest.getBuildingStoreys());
		property.setPropertyValue(propertyValue);
		property.setCostOftheAsset(updateRequest.getCostOftheAsset());
		property.setSalvageValue(updateRequest.getSalvageValue());
		property.setUsefulLifeofAsset(updateRequest.getUsefulLifeofAsset());
		
		Property propertySavedObj = propertyRepository.save(property);
		
		log.debug("Property Updated Obj {} ", propertySavedObj);
		
		return "Update Property Success";
		
	}

	/*Method to calculate value of a property*/
	private Long calculatePropertyValue(@NotNull Long costOftheAsset, @NotNull Long salvageValue,
			@NotNull Long usefulLifeofAsset) {
		

		Double x_ratio = (double) ((costOftheAsset - salvageValue) / usefulLifeofAsset);
		log.debug("x_ratio : {}", x_ratio);
		Double Range_min = 0D;
		Double Range_max = 10D;
		Double x_max = (double) (costOftheAsset / usefulLifeofAsset);
		log.debug("x_max : {}", x_max);
		Double x_min = (double) (salvageValue / usefulLifeofAsset);
		log.debug("x_min : {}", x_min);
		Double range_diff = (Range_max - Range_min);
		log.debug("range_diff : {}", range_diff);
		Double sat = ((x_ratio - x_min) / (x_max - x_min));
		log.debug("(x_ratio - x_min) / (x_max - x_min): {}", sat);
		Double propertyvalue = range_diff * sat;
		log.debug("propertyvalue  : {}", propertyvalue);
		log.info("End calPropertyValue");
		return (long) Math.abs(Math.round(propertyvalue));

	}

}
