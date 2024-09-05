package com.saad.product.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.lang.NonNull;

public record ProductPurchaseRequest(
        @NotNull(message="product is required")
        Integer productId,
        @Positive (message="Quantity is required")
        double quantity

) {
}
