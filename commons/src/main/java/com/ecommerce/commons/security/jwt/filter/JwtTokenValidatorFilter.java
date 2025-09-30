package com.ecommerce.commons.security.jwt.filter;

import com.ecommerce.commons.security.CustomUsernamePasswordAuth;
import com.ecommerce.commons.security.SecurityConstants;
import com.ecommerce.commons.security.ThreadLocalAuthStore;
import com.ecommerce.commons.security.jwt.JwtTokenWrapperService;
import com.ecommerce.commons.security.jwt.JwtUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtTokenValidatorFilter extends OncePerRequestFilter implements SecurityConstants {
    @Autowired
    private JwtTokenWrapperService jwtTokenWrapperService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(AUTHORIZATION_HEADER);

        if (header==null || !header.startsWith(AUTHENTICATION_PREFIX)){
            filterChain.doFilter(request,response);
            return;
        }

        String token = header.replace(AUTHENTICATION_PREFIX,"").trim();
        JwtUser user = jwtTokenWrapperService.validateToken(token);
        if (user!=null) {
            List<SimpleGrantedAuthority> authorities = user.getAuthorities().stream().map(SimpleGrantedAuthority::new).toList();

            Authentication authentication = new CustomUsernamePasswordAuth(user.getPrincipal(),null,authorities,user.getFullName(), user.getUserId());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            ThreadLocalAuthStore.updateThreadStore(token);
        }
        filterChain.doFilter(request,response);
    }
}
