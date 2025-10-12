package com.ecommerce.commons.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {
    private UUID id;
    private double loyaltyPoints;
    private Long defaultBillingAddressId;
    private Long defaultShippingAddressId;
    private String referralCode;
    private String preferredPaymentMode;
    private Date dob;
    private double ratings;
    private String userId;
}
