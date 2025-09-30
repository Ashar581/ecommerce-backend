package com.ecommerce.commons.controller;

import com.ecommerce.commons.model.base.BaseApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseControllerDelegate {

    protected <T> ResponseEntity<BaseApiResponse<T>> sendSuccessfulApiResponse(T data, String message){
        BaseApiResponse<T> response = new BaseApiResponse<>();
        response.setStatus(true);
        response.setCode(HttpStatus.OK.value());
        response.setMessage(message);
        response.setData(data);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    protected  <T> ResponseEntity<BaseApiResponse<T>> sendSuccessfullyCreatedApiResponse(T data,String message){
        BaseApiResponse<T> response = new BaseApiResponse<>();
        response.setStatus(true);
        response.setCode(HttpStatus.CREATED.value());
        response.setMessage(message);
        response.setData(data);

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    protected <T> ResponseEntity<BaseApiResponse<T>> sendSuccessfulApiResponseWithoutMessage(T data){
        BaseApiResponse<T> response = new BaseApiResponse<>();
        response.setStatus(true);
        response.setCode(HttpStatus.OK.value());
        response.setMessage("");
        response.setData(data);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
