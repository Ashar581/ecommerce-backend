package com.ecommerce.commons.security;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomUsernamePasswordAuth extends UsernamePasswordAuthenticationToken {
    @Getter
    private String fullName;
    @Getter
    private String userId;

    public CustomUsernamePasswordAuth(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public CustomUsernamePasswordAuth(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public CustomUsernamePasswordAuth(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities,String fullName,String userId) {
        super(principal, credentials, authorities);
        this.fullName = fullName;
        this.userId = userId;
    }
}
