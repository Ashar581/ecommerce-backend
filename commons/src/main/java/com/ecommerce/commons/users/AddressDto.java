package com.ecommerce.commons.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
    private Long id;
    private String street;
    @NotNull(message = "Pin code is mandatory.")
    private String pinCode;
    private String landmark;
    private String area;
    @NotNull(message = "City is mandatory.")
    private String city;
    @NotNull(message = "State is mandatory.")
    private String state;
    @NotNull(message = "Country is mandatory.")
    private String country;
    private String userId;
}
