package com.ecommerce.users.config;

import com.ecommerce.commons.security.jwt.filter.JwtTokenValidatorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;
import java.util.List;

@Configuration
public class AppSecurityConfig {

    @Autowired
    private JwtTokenValidatorFilter jwtTokenValidatorFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(cors->cors
                        .configurationSource(request->{
                            CorsConfiguration config = new CorsConfiguration();
                            config.setAllowedHeaders(List.of("*"));
                            config.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
                            config.setExposedHeaders(List.of("Authorization"));
                            config.setAllowedOrigins(Collections.singletonList("*"));

                            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                            source.registerCorsConfiguration("/users/**",config);

                            return source.getCorsConfiguration(request);
                        }))
                .authorizeHttpRequests(auth-> auth
                                .requestMatchers("public/**").permitAll()
                                .anyRequest().authenticated())
                .addFilterBefore(jwtTokenValidatorFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}
