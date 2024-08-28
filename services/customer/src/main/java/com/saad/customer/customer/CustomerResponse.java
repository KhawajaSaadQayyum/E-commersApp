package com.saad.customer.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerResponse(
        Integer id,

        String firstname,

        String lastname,


        String email,
        Address address
) {


}
