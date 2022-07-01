package com.cts.policymodule.Controller;

import com.cts.policymodule.Exception.ConsumerBusinessNotFoundException;
import com.cts.policymodule.Exception.ConsumerPolicyNotFoundException;
import com.cts.policymodule.Exception.PolicyNotFoundException;
import com.cts.policymodule.Payload.Request.CreatePolicyRequest;
import com.cts.policymodule.Payload.Request.IssuePolicyRequest;
import com.cts.policymodule.Payload.Response.MessageResponse;
import com.cts.policymodule.Payload.Response.PolicyDetailsResponse;
import com.cts.policymodule.Payload.Response.QuoteDetailsResponse;
import com.cts.policymodule.Repository.ConsumerPolicyRepository;
import com.cts.policymodule.Repository.PolicyMasterRepository;
import com.cts.policymodule.Service.PolicyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private PolicyMasterRepository policyMasterRepository;

    @Autowired
    private ConsumerPolicyRepository consumerPolicyRepository;

    @PostMapping("/createPolicy")
    @HystrixCommand(fallbackMethod = "sendPolicyErrorResponse")
    public MessageResponse createPolicy(@Valid @RequestBody CreatePolicyRequest createPolicyRequest) throws ConsumerBusinessNotFoundException {
        MessageResponse messageResponse = policyService.createPolicy(createPolicyRequest);
        return messageResponse;
    }

    @PostMapping("/issuePolicy")
    @HystrixCommand(fallbackMethod = "sendPolicyErrorResponse")
    public MessageResponse issuePolicy(@Valid @RequestBody IssuePolicyRequest issuePolicyRequest) throws ConsumerPolicyNotFoundException, PolicyNotFoundException {
        if (!consumerPolicyRepository.existsByConsumerId(issuePolicyRequest.getConsumerId())) {
            return new MessageResponse("Sorry!!, No Consumer Found!!");
        }
        if (!policyMasterRepository.existsByPid(issuePolicyRequest.getPolicyId())) {
            return new MessageResponse("Sorry!!, No Policy Found!!");
        }
        if (!(issuePolicyRequest.getPaymentDetails().equals("Success"))) {
            return new MessageResponse("Sorry!!, Payment Failed!! Try Again");
        }
        if (!(issuePolicyRequest.getAcceptanceStatus().equals("Accepted"))) {
            return new MessageResponse("Sorry!!, Accepted Failed !! Try Again");
        }
        MessageResponse messageResponse = policyService.issuePolicy(issuePolicyRequest);
        return messageResponse;
    }

    @GetMapping("/viewPolicy")
    @HystrixCommand(fallbackMethod = "sendPolicyErrorResponse")
    public ResponseEntity<?> viewPolicy(@Valid @RequestParam Long consumerId, @RequestParam String policyId) throws ConsumerPolicyNotFoundException, PolicyNotFoundException {
        if (!policyMasterRepository.existsByPid(policyId)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Sorry!!, No Policy Found!!"));
        }
        if (!consumerPolicyRepository.existsByConsumerId(consumerId)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Sorry!!, No Consumer Found!!"));
        }
        PolicyDetailsResponse policyDetailsResponse = policyService.viewPolicy(consumerId, policyId);
        return ResponseEntity.ok(policyDetailsResponse);
    }

    @GetMapping("/getQuotes")
    @HystrixCommand(fallbackMethod = "sendPolicyErrorResponse")
    public ResponseEntity<QuoteDetailsResponse> getQuotes(@Valid @RequestParam Long businessValue, @RequestParam Long propertyValue, @RequestParam String propertyType) {
        QuoteDetailsResponse quoteDetailsResponse = policyService.getQuotes(businessValue, propertyValue, propertyType);
        return ResponseEntity.ok(quoteDetailsResponse);
    }

    public MessageResponse sendPolicyErrorResponse() {
        return new MessageResponse("Policy Error Response !!!");
    }
}
