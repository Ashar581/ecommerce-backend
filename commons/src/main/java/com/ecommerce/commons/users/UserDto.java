package com.ecommerce.commons.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto <T>{
    private UUID id;
    @NotNull(message = "First name is mandatory.")
    private String firstName;
    @NotNull(message = "Last name is mandatory.")
    private String lastName;
    private String fullName;
    @NotNull(message = "Email is mandatory.")
    private String email;
    private String phoneNumber;
    private String userId;
    @NotNull(message = "Time zone is mandatory.")
    private String timezone;
    private Instant createdAt;
    private String createdBy;
    private Instant updatedAt;
    private String updatedBy;
    private Set<String> roles;
    //customer,admin,delivery agent,
    private T userProfileType;

    public String getFullName(){
        return this.firstName +" "+this.lastName.trim();
    }

}
