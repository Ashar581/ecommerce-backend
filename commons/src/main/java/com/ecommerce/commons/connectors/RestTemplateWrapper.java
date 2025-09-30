package com.ecommerce.commons.connectors;

import com.ecommerce.commons.security.SecurityConstants;
import com.ecommerce.commons.security.ThreadLocalAuthStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@Slf4j
@Component
public class RestTemplateWrapper implements SecurityConstants {
    @Autowired
    private RestTemplate restTemplate;

    protected <T> T get(URI uri, Class<T> serializableClass, Map<String,String> headers){
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            addBearerToken(httpHeaders);

            if (headers != null) {
                headers.keySet().forEach(h -> httpHeaders.set(h, headers.get(h)));
            }

            HttpEntity<Void> httpEntity = new HttpEntity<>(null, httpHeaders);

            ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, serializableClass);

            return response.getBody();
        }catch (Exception e){
            log.error("Error invoking get : {}",uri.toString());
            return null;
        }
    }

    protected <T> T get(URI uri, ParameterizedTypeReference<T> serializableClass, Map<String,String> header){
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            addBearerToken(httpHeaders);

            if (header!=null){
                header.keySet().forEach(h->httpHeaders.set(h,header.get(h)));
            }

            HttpEntity<Void> httpEntity = new HttpEntity<>(null, httpHeaders);

            ResponseEntity<T> response = restTemplate.exchange(uri,HttpMethod.GET,httpEntity,serializableClass);

            return response.getBody();
        }catch (Exception e){
            log.error("Error invoking GET api: {}",uri.toString());
            return null;
        }
    }

    protected <T,T1> T post(URI uri, T1 body, Class<T> serializableClass, Map<String,String> header){
        try{
            HttpHeaders httpHeaders = new HttpHeaders();
            addBearerToken(httpHeaders);

            if (header!=null){
                header.keySet().forEach(h->httpHeaders.set(h,header.get(h)));
            }

            HttpEntity<T1> httpEntity = new HttpEntity<>(body,httpHeaders);
            ResponseEntity<T> response = restTemplate.exchange(uri,HttpMethod.POST,httpEntity,serializableClass);

            return response.getBody();
        }catch (Exception e){
            log.error("Error invoking POST api: {}",uri.toString());
            return null;
        }
    }

    protected <T,T1> T post(URI uri,T1 body, ParameterizedTypeReference<T> serializableClass, Map<String,String> headers){
        try{
            HttpHeaders httpHeaders = new HttpHeaders();
            addBearerToken(httpHeaders);

            if (headers!=null){
                headers.keySet().forEach(h->httpHeaders.set(h,headers.get(h)));
            }

            HttpEntity<T1> httpEntity = new HttpEntity<>(body,httpHeaders);
            ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, serializableClass);

            return response.getBody();
        }catch(Exception e){
            log.error("Error invoking POST api: {}",uri.toString());
            return null;
        }
    }

    protected <T,T1> T put(URI uri,T1 body,Class<T> serializableClass, Map<String,String> headers){
        try{
            HttpHeaders httpHeaders = new HttpHeaders();
            addBearerToken(httpHeaders);

            if (headers!=null){
                headers.keySet().forEach(h->httpHeaders.set(h,headers.get(h)));
            }
            HttpEntity<T1> httpEntity = new HttpEntity<>(body,httpHeaders);

            ResponseEntity<T> response = restTemplate.exchange(uri,HttpMethod.PUT,httpEntity,serializableClass);
            return response.getBody();
        }catch(Exception e){
            log.error("Error invoking PUT api: {}",uri.toString());
            return null;
        }
    }

    protected <T,T1> T put(URI uri, T1 body, ParameterizedTypeReference<T> serializableClass, Map<String,String> headers){
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            addBearerToken(httpHeaders);

            if (headers!=null){
                headers.keySet().forEach(h->httpHeaders.set(h,headers.get(h)));
            }
            HttpEntity<T1> httpEntity = new HttpEntity<>(body,httpHeaders);
            ResponseEntity<T> response = restTemplate.exchange(uri,HttpMethod.PUT,httpEntity,serializableClass);

            return response.getBody();
        }catch (Exception e){
            log.error("Error invoking PUT api: {}",uri.toString());
            return null;
        }
    }

    protected <T> T delete(URI uri, Class<T> serializableClass, Map<String,String> headers){
        try{
            HttpHeaders httpHeaders = new HttpHeaders();
            addBearerToken(httpHeaders);

            if (headers!=null){
                headers.keySet().forEach(h->httpHeaders.set(h,headers.get(h)));
            }

            HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);
            ResponseEntity<T> response = restTemplate.exchange(uri,HttpMethod.DELETE,httpEntity,serializableClass);

            return response.getBody();
        }catch (Exception e){
            log.error("Error invoking DELETE api: {}",uri.toString());
            return null;
        }
    }

    protected <T> T delete(URI uri,ParameterizedTypeReference<T> serializableClass, Map<String,String> headers){
        try{
            HttpHeaders httpHeaders = new HttpHeaders();
            addBearerToken(httpHeaders);

            if (headers!=null){
                headers.keySet().forEach(h->httpHeaders.set(h,headers.get(h)));
            }
            HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);

            ResponseEntity<T> response = restTemplate.exchange(uri,HttpMethod.DELETE,httpEntity,serializableClass);

            return response.getBody();
        }catch (Exception e){
            log.error("Error invoking DELETE api: {}",uri.toString());
            return null;
        }
    }

    protected <T> T uploadFile(URI uri, Class<T> serializableClass, Map<String,String> params, Map<String,String> headers){
        try{
            HttpHeaders httpHeaders = new HttpHeaders();
            addBearerToken(httpHeaders);
            httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

            if (headers!=null){
                headers.keySet().forEach(h->httpHeaders.set(h,headers.get(h)));
            }

            MultiValueMap<String,Object> body = new LinkedMultiValueMap<>();
            if (params!=null){
                params.keySet().forEach(p->body.add(p,params.get(p)));
            }

            HttpEntity<MultiValueMap<String,Object>> httpEntity = new HttpEntity<>(body,httpHeaders);

            ResponseEntity<T> response = restTemplate.exchange(uri,HttpMethod.POST,httpEntity,serializableClass);

            return response.getBody();
        }catch (Exception e){
            log.error("Error while invoking file upload: {}",uri.toString());
            return null;
        }
    }

    private void addBearerToken(HttpHeaders httpHeaders){
        String token = ThreadLocalAuthStore.getToken();
        if (token !=null){
            httpHeaders.set(AUTHORIZATION_HEADER,String.format("%s %s",AUTHENTICATION_PREFIX,token));
        }
    }
}
