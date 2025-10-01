package com.ecommerce.users.model;

import com.ecommerce.users.entity.Address;
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
    private Address address;
    private boolean isPrimary;
    private Date dob;
}
