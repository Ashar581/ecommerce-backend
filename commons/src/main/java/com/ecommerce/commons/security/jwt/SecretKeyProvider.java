package com.ecommerce.commons.security.jwt;

import com.ecommerce.commons.security.jwt.config.KeyConfig;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;

/**
 * We select the secret key for the token in accordance with the settings in yml. The logic is when we run the
 * program we decide what secret key we should take. We have 2 options, take it from yml or take is from Environment
 * variables (Docker). If the key type is 'shared' and not null, we get the secret key from yml and
 * if it is null or not 'shared', we take it from environment variable. We get the environment variable's
 * name from the yml itself.
 */
@Slf4j
@Component
public class SecretKeyProvider {

    @Autowired
    private KeyConfig keyConfig;
    @Autowired
    private Environment environment;
    @Autowired
    private ApplicationContext applicationContext;
    @Getter
    private Key secretKey;

    @PostConstruct
    public void init(){
        String signingKey = null;
        boolean shared = false;

        if (keyConfig.getKeyType() !=null ){
            shared = keyConfig.getKeyType().equalsIgnoreCase("shared");
        }

        if (keyConfig.isUseEnvVar()){
            signingKey = environment.getProperty(keyConfig.getKeyEnvVar(),"");
            if (signingKey.isBlank()){
                log.error("Unable to find the secret key from environment variables.");
                ((ConfigurableApplicationContext)applicationContext).close();
            }
        } else {
            signingKey = keyConfig.getSecretKey();
        }

        if (shared){
            secretKey = Keys.hmacShaKeyFor(signingKey.getBytes());
        } else {
            secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        }
    }

}
