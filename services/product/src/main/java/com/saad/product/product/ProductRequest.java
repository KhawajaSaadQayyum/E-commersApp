package com.saad.product.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

public record ProductRequest(
         Integer id,
         @NotNull(message= "Product name is required")
         String name,
         @NotNull(message= "Product Description is required")
         String description,
         @Positive(message= "Quantity should be positive")
         double availableQuantity,
         @Positive(message= "Price should be positive")
         BigDecimal price,
         @NotNull(message= "Category ID is required")
         Integer categoryId

) {
}
