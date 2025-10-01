package com.ecommerce.users.model;

import com.ecommerce.users.entity.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankDetails {
    private BankAccountType bankAccountType;
    private String ifsc;
    private String bankNumber;
    private String branch;
    private String bankName;
    private Address address;
    private boolean isVerified;
    private boolean isPrimary;
}
