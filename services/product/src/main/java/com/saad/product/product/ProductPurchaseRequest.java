package com.saad.product.product;

import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

public record ProductPurchaseRequest(
        @NotNull(message="product is required")
        Integer productId,
        @NotNull(message="Quantity is required")
        double quantity

) {
}
