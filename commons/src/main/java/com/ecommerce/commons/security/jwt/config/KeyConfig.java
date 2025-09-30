package com.ecommerce.commons.security.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("app.security.key")
public class KeyConfig {
    private String secretKey;
    private String keyType;
    private boolean useEnvVar;
    private String keyEnvVar;
}
