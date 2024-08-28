package com.saad.customer.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.message.Message;

public record CustomerRequest(
        Integer id,
        @NotNull(message = "Customer first name is required")
        String firstname,
        @NotNull(message= "Customer last name is required")
        String lastname,
        @NotNull(message= "Customer email name is required")
        @Email(message= "Customer email is not a valid email address")
        String email,
        Address address
) {


}
