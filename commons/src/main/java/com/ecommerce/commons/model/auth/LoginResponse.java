package com.ecommerce.commons.model.auth;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String refreshToken;
    //userDto
}
