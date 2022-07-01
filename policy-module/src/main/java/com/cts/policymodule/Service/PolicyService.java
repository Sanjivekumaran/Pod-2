package com.cts.policymodule.Service;

import com.cts.policymodule.Entities.ConsumerPolicy;
import com.cts.policymodule.Entities.PolicyMaster;
import com.cts.policymodule.Exception.ConsumerBusinessNotFoundException;
import com.cts.policymodule.Exception.ConsumerPolicyNotFoundException;
import com.cts.policymodule.Exception.PolicyNotFoundException;
import com.cts.policymodule.Payload.Request.CreatePolicyRequest;
import com.cts.policymodule.Payload.Request.IssuePolicyRequest;
import com.cts.policymodule.Payload.Response.ConsumerBusinessDetails;
import com.cts.policymodule.Payload.Response.MessageResponse;
import com.cts.policymodule.Payload.Response.PolicyDetailsResponse;
import com.cts.policymodule.Payload.Response.QuoteDetailsResponse;
import com.cts.policymodule.Repository.ConsumerPolicyRepository;
import com.cts.policymodule.Repository.PolicyMasterRepository;
import com.cts.policymodule.RestClients.ConsumerClient;
import com.cts.policymodule.RestClients.QuotesClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class PolicyService {

    @Autowired
    private ConsumerPolicyRepository consumerPolicyRepository;

    @Autowired
    private PolicyMasterRepository policyMasterRepository;

    @Autowired
    private ConsumerClient consumerClient;

    @Autowired
    private QuotesClient quotesClient;

    public QuoteDetailsResponse getQuotes(Long businessValue, Long propertyValue, String propertyType) {
        String quote = quotesClient.quotesResponse(businessValue, propertyValue, propertyType);
        return (new QuoteDetailsResponse(quote));
    }

    public PolicyDetailsResponse viewPolicy(long consumerId, String policyId) throws PolicyNotFoundException, ConsumerPolicyNotFoundException {
        PolicyMaster policyMaster = policyMasterRepository.findByPid(policyId);
        ConsumerPolicy consumerPolicy = consumerPolicyRepository.findByConsumerId(consumerId);
        PolicyDetailsResponse policyDetailsResponse = new PolicyDetailsResponse(consumerId, policyMaster.getPolicyId(), policyMaster.getPropertyType(), policyMaster.getConsumerType(), policyMaster.getAssuredSum(), policyMaster.getTenure(), policyMaster.getBusinessValue(), policyMaster.getPropertyValue(), policyMaster.getBaseLocation(), policyMaster.getType(), consumerPolicy.getBusinessId(), consumerPolicy.getPaymentDetails(), consumerPolicy.getAcceptanceStatus(), consumerPolicy.getPolicyStatus(), consumerPolicy.getEffectiveDate(), consumerPolicy.getCoveredSum(), consumerPolicy.getDuration(), consumerPolicy.getAcceptedQuote());
        return policyDetailsResponse;
    }

    public MessageResponse createPolicy(CreatePolicyRequest createPolicyRequest) throws ConsumerBusinessNotFoundException {
        ConsumerBusinessDetails consumerBusinessDetails = getConsumerBusiness(createPolicyRequest.getConsumerId());
        if (consumerBusinessDetails == null) {
            return new MessageResponse("No Consumer Business Found !!");
        }
        ConsumerPolicy consumerPolicy = new ConsumerPolicy(consumerBusinessDetails.getConsumerId(), consumerBusinessDetails.getBusinessId(), "Initiated", createPolicyRequest.getAcceptedQuotes());
        ConsumerPolicy consumerPolicySave = consumerPolicyRepository.save(consumerPolicy);
        return new MessageResponse("Policy Has been Created with Policy Consumer Id : " + consumerPolicySave.getId() + " .Thank You Very Much!!");
    }

    public ConsumerBusinessDetails getConsumerBusiness(Long consumerId) throws ConsumerBusinessNotFoundException {
        ConsumerBusinessDetails consumerBusinessDetails = consumerClient.viewConsumerBusiness(consumerId);
        return consumerBusinessDetails;
    }

    public MessageResponse issuePolicy(IssuePolicyRequest issuePolicyRequest) throws ConsumerPolicyNotFoundException, PolicyNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ConsumerPolicy consumerPolicy = consumerPolicyRepository.findByConsumerIdAndBusinessId(issuePolicyRequest.getConsumerId(), issuePolicyRequest.getBusinessId());
        PolicyMaster policyMaster = policyMasterRepository.findByPid(issuePolicyRequest.getPolicyId());
        consumerPolicy.setPolicyId(issuePolicyRequest.getPolicyId());
        consumerPolicy.setPaymentDetails(issuePolicyRequest.getPaymentDetails());
        consumerPolicy.setAcceptanceStatus(issuePolicyRequest.getAcceptanceStatus());
        consumerPolicy.setPolicyStatus("Issued");
        consumerPolicy.setEffectiveDate(dtf.format(now));
        consumerPolicy.setDuration(policyMaster.getTenure());
        consumerPolicy.setCoveredSum(policyMaster.getAssuredSum());
        ConsumerPolicy consumerPolicySave = consumerPolicyRepository.save(consumerPolicy);
        return new MessageResponse("Policy has Issued to PolicyConsumer Id : " + consumerPolicySave.getId() + " .Thank You Very Much!!");
    }

}
