package com.ecommerce.commons.model.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String userId;
    private String password;
    private String otp;
}
