package com.saad.customer.customer.handler;

import com.saad.customer.customer.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler (CustomerNotFoundException.class)
    public ResponseEntity<String> handle (CustomerNotFoundException exp){
        return  ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exp.getMsg());
    }
// Error can be  at this method
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle (MethodArgumentNotValidException exp){

        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error ->{
                    var fieldName= ((FieldError)error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                });
        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST).body(new ErrorResponse() {
                    @Override
                    public HttpStatusCode getStatusCode() {
                        return null;
                    }

                    @Override
                    public ProblemDetail getBody() {
                        return null;
                    }
                });
    }

}
