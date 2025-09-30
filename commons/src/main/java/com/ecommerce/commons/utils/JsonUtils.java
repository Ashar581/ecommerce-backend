package com.ecommerce.commons.utils;

import com.ecommerce.commons.exception.UnexpectedFailureException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class JsonUtils {
    @Autowired
    private ObjectMapper objectMapper;

    public <T> Map<String,Object> serializeToMap(T object){
        try{
            return objectMapper.convertValue(object, new TypeReference<Map<String, Object>>() {});
        }catch (Exception e){
            log.error("Unable to serialize object: {}",e.getMessage());
            throw new UnexpectedFailureException("Serialization failure.");
        }
    }

    public <T> T deserializeMap(Map<String,Object> from, Class<T> to){
        try{
            return objectMapper.convertValue(from,to);
        }catch (Exception e){
            log.error("Unable to deserialize object: {}",e.getMessage());
            throw new UnexpectedFailureException("Deserialization failure.");
        }
    }

    public <T> T deserializeMap(Map<String, Object> from, TypeReference<T> to) {
        try {
            return objectMapper.convertValue(from, to);
        } catch (Exception e) {
            log.error("Unable to deserialize object: {}", e.getMessage());
            throw new UnexpectedFailureException("Deserialization failure.");
        }
    }

    public <T,T1> T1 deserialize(T from, Class<T1> to){
        try {
            return objectMapper.convertValue(from, to);
        } catch (Exception e) {
            log.error("Unable to deserialize object: {}", e.getMessage());
            throw new UnexpectedFailureException("Deserialization failure.");
        }
    }

    public <T,T1> T1 deserialize(T from, TypeReference<T1> to){
        try {
            return objectMapper.convertValue(from, to);
        } catch (Exception e) {
            log.error("Unable to deserialize object: {}", e.getMessage());
            throw new UnexpectedFailureException("Deserialization failure.");
        }
    }
}
