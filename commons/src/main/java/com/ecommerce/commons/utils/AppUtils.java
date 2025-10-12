package com.ecommerce.commons.utils;

import com.ecommerce.commons.security.CustomUsernamePasswordAuth;
import com.ecommerce.commons.security.jwt.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class AppUtils {
    public static JwtUser getLoggedInUser(){
        try {
            var authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = String.valueOf(authentication.getPrincipal());
            JwtUser user = new JwtUser();
            user.setPrincipal(username);
            if (authentication instanceof CustomUsernamePasswordAuth){
                user.setUserId(((CustomUsernamePasswordAuth)authentication).getUserId());
                user.setFullName(((CustomUsernamePasswordAuth) authentication).getFullName());
            }
            user.setAuthorities(authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());

            return user;
        }catch (Exception e){
            return new JwtUser();
        }
    }
    public static String lemmatize(String data){
        if (data==null) return null;

        return data.replaceAll("^[A-Za-z0-9]","");
    }

    public static String lemmatizeAndUpperCase(String data){
        if (data==null) return null;

        return data.replaceAll("^[A-Za-z0-9]]","").toUpperCase();
    }

}
