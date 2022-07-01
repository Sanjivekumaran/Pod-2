package com.cts.policymodule.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerBusinessDetails {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String dob;

    @NotBlank
    private String businessName;

    @NotBlank
    private String panDetails;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String website;

    @NotBlank
    private String businessOverview;

    @NotBlank
    private String validity;

    @NotBlank
    private String agentName;

    @NotNull
    private Long agentId;

    @NotNull
    private Long businessId;

    @NotNull
    private Long consumerId;

    @NotBlank
    private String businessCategory;

    @NotBlank
    private String businessType;

    @NotNull
    private Long businessTurnover;

    @NotNull
    private Long capitalInvested;

    @NotNull
    private Long totalEmployees;

    @NotNull
    private Long businessValue;

    @NotNull
    private Long businessAge;

}
