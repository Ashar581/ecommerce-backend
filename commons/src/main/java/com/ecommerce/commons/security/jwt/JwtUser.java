package com.ecommerce.commons.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtUser {
    private String principal;
    private String userId;
    private String fullName;
    private List<String> authorities;

    public String getPrincipal(){
        return principal==null?"Anonymous":principal;
    }
}
