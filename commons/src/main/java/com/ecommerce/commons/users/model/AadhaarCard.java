package com.ecommerce.commons.users.model;

import com.ecommerce.commons.users.AddressDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AadhaarCard {
    private String name;
    private String aadhaarNumber;
    private String fathersName;
    private AddressDto address;
    private boolean isPrimary;
    private Date dob;
}
