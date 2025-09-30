package com.ecommerce.commons.exception.handler;

import com.ecommerce.commons.configs.TimeFormat;
import com.ecommerce.commons.exception.*;
import com.ecommerce.commons.model.base.BaseExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler implements TimeFormat {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseExceptionResponse> exceptionHandler(Exception ex){
        return new ResponseEntity<>(BaseExceptionResponse.builder()
                .status(false)
                .message(ex.getMessage())
                .code(HttpStatus.EXPECTATION_FAILED.value())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern(GENERAL_FORMAT)))
                .build(),HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(ActionRestrictedException.class)
    public ResponseEntity<BaseExceptionResponse> actionRestrictedExceptionHandler(ActionRestrictedException are){
        return new ResponseEntity<>(BaseExceptionResponse.builder()
                .status(false)
                .code(HttpStatus.NOT_ACCEPTABLE.value())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern(GENERAL_FORMAT)))
                .message(are.getMessage())
                .build(),HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ApiFallbackException.class)
    public ResponseEntity<BaseExceptionResponse> apiFallbackExceptionHandler(ApiFallbackException afe){
        return new ResponseEntity<>(BaseExceptionResponse.builder()
                .status(false)
                .code(HttpStatus.BAD_GATEWAY.value())
                .message(afe.getMessage())
                .timestamp(LocalDateTime.MIN.format(DateTimeFormatter.ofPattern(GENERAL_FORMAT)))
                .build(),HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseExceptionResponse> notFoundExceptionHandler(NotFoundException nfe){
        return new ResponseEntity<>(BaseExceptionResponse.builder()
                .status(false)
                .code(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.MIN.format(DateTimeFormatter.ofPattern(GENERAL_FORMAT)))
                .message(nfe.getMessage())
                .build(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullValueException.class)
    public ResponseEntity<BaseExceptionResponse> nullValueException(NullValueException nve){
        return new ResponseEntity<>(BaseExceptionResponse.builder()
                .status(false)
                .code(HttpStatus.PRECONDITION_FAILED.value())
                .timestamp(LocalDateTime.MIN.format(DateTimeFormatter.ofPattern(GENERAL_FORMAT)))
                .message(nve.getMessage())
                .build(),HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<BaseExceptionResponse> alreadyExistExceptionHandler(AlreadyExistException aee){
        return new ResponseEntity<>(BaseExceptionResponse.builder()
                .status(false)
                .code(HttpStatus.CONFLICT.value())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern(GENERAL_FORMAT)))
                .message(aee.getMessage())
                .build(),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<BaseExceptionResponse> authenticationExceptionHandler(AuthenticationException ae){
        return new ResponseEntity<>(BaseExceptionResponse.builder()
                .status(false)
                .code(HttpStatus.UNAUTHORIZED.value())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern(GENERAL_FORMAT)))
                .message(ae.getMessage())
                .build(),HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UnexpectedFailureException.class)
    public ResponseEntity<BaseExceptionResponse> unexpectedFailureExceptionHandler(UnexpectedFailureException ufe){
        return new ResponseEntity<>(BaseExceptionResponse.builder()
                .status(false)
                .code(HttpStatus.SERVICE_UNAVAILABLE.value())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern(GENERAL_FORMAT)))
                .message(ufe.getMessage())
                .build(),HttpStatus.SERVICE_UNAVAILABLE);
    }
}
