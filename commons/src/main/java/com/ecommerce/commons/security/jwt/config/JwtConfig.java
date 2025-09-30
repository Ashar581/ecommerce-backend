package com.ecommerce.commons.security.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("aap.security.jwt")
public class JwtConfig {
    private String audience;
    private String issuer;
    private long atexpirationtimeinmin;
    private long rtexpirationtimeinmin;
}
