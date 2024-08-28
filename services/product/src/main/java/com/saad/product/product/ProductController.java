package com.saad.product.product;

import jakarta.validation.Valid;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Integer> createProduct(
            @RequestBody @Valid ProductRequest request
    ){
    return ResponseEntity.ok(service.createProduct(request));
    }


    @PostMapping ("/purchase")

    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(
            @RequestBody List<ProductPurchaseRequest> request
    ){
        return ResponseEntity.ok(service.purchaseProduct(request));
    }
    @GetMapping("/{product-id}")

    public ResponseEntity<ProductResponse>  findById(
            @PathVariable ("product-id") Integer productId
    ){
        return ResponseEntity.ok(service.findById(productId));
    }


    @GetMapping

    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

}
