package com.ecommerce.commons.security;

/**
 * This class is used for storing the Token for single thread. The lifespan of this will always be
 * for a single thread. This will help in using the current token for internal api calls. This gets
 * set in the token validation filter, the entry point of the request finally reaching the controller.
 */
public class ThreadLocalAuthStore {
    private static final ThreadLocal<TokenStore> threadLocalAuthStore = new ThreadLocal<>();

    public static TokenStore getTokenStore(){
        return threadLocalAuthStore.get();
    }

    public static void updateThreadStore(String token){
        TokenStore tokenStore = getTokenStore();
        if (tokenStore==null){
            tokenStore = new TokenStore();
            threadLocalAuthStore.set(tokenStore);
        }
        tokenStore.setToken(token);
    }

    public static String getToken(){
        TokenStore tokenStore = getTokenStore();
        if (tokenStore!=null){
            return tokenStore.getToken();
        }
        return null;
    }

    public static void clearTokenStore(){
        threadLocalAuthStore.remove();
    }
}
