package com.saad.customer.customer;

import com.saad.customer.customer.exception.CustomerNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor

public class CustomerService {

    private final customerRepositry repositry;
    private final CustomerMapper mapper;


    public Integer createCustomer(CustomerRequest request) {
        var customer = repositry.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        var customer = repositry.findById(request.id())
                .orElseThrow(()-> new CustomerNotFoundException(
                      format("Cannot Update Customer:: no customer found %s",request.id())
                ));
        mergeCustomer(customer, request);
        repositry.save(customer);
    }

    private void mergeCustomer(Customer customer, @Valid CustomerRequest request) {

        if(StringUtils.isNotBlank(request.firstname())){
            customer.setFirstname(request.firstname());
        }
        if(StringUtils.isNotBlank(request.lastname())){
            customer.setFirstname(request.lastname());
        }
        if(StringUtils.isNotBlank(request.email())){
            customer.setFirstname(request.email());
        }
        if(request.address()!=null){
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return repositry.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());

    }

    public boolean existsById(String customerId) {
        return repositry.findById(Integer.valueOf(customerId))
                .isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return repositry.findById(Integer.valueOf(customerId))
                .map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(format("No Customer Found with this Id %s",customerId)));
    }

    public void deleteCustomer(String customerId) {
        repositry.deleteById(Integer.valueOf(customerId));
    }
}
