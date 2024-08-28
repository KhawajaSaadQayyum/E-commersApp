package com.saad.customer.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/customer")
@RequiredArgsConstructor
public class customerController {

    private final CustomerService service;

    @PatchMapping
    public ResponseEntity<Integer> createCustomer(
            @RequestBody @Valid CustomerRequest request
            ){
        return ResponseEntity.ok(service.createCustomer(request));
    }
  @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest request
  ) {
      service.updateCustomer(request);
      return ResponseEntity.accepted().build();
  }
  @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return  ResponseEntity.ok(service.findAllCustomers());
  }

  @GetMapping("/exist/{customer-id}")
    public ResponseEntity<Boolean> existById(
            @PathVariable ("customer-id") String customerId
  ){
        return ResponseEntity.ok(service.existsById(customerId));
  }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable ("customer-id") String customerId
    ){
        return ResponseEntity.ok(service.findById(customerId));
    }
    @DeleteMapping ("/{customer-id}")
    public ResponseEntity<Void> delete(@PathVariable("customer-id") String customerId){
        service.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }
}
