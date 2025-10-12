package com.ecommerce.commons.users;

import com.ecommerce.commons.users.model.AadhaarCard;
import com.ecommerce.commons.users.model.BankDetails;
import com.ecommerce.commons.users.model.Pan;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendorDto {
    private UUID id;
    @NotNull(message = "Company name is mandatory.")
    private String companyName;
    private Long companyAddressId;
    private Long personalAddressId;
    @NotNull(message = "Pan details are mandatory.")
    private List<Pan> pans;
    @NotNull(message = "Bank details are mandatory.")
    private List<BankDetails> bankDetails;
    @NotNull(message = "Aadhaar details are mandatory.")
    private List<AadhaarCard> aadhaarCards;
    @NotNull(message = "GST number is mandatory.")
    private String gstNumber;
    private Date dob;
    private double ratings;
    private String supportEmail;
    private String supportContact;
    private Set<Long> productIds;
    private String userId;
}
