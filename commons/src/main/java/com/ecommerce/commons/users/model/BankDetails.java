package com.ecommerce.commons.users.model;

import com.ecommerce.commons.users.AddressDto;
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
    private AddressDto address;
    private boolean isVerified;
    private boolean isPrimary;
}
