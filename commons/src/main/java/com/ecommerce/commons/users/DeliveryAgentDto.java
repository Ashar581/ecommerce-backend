package com.ecommerce.commons.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveryAgentDto {
    private UUID id;
    private String vehicleType;
    private String drivingLicence;
    private String assignedZone;
    private boolean isActive;
    private String userId;
}
