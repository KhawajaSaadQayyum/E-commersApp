package com.saad.customer.customer.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String,String> errors
) {


    public ErrorResponse(Map<String, String> errors) {
        this.errors = errors;
    }
}
