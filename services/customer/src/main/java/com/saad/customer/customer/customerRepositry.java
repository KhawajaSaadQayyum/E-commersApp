package com.saad.customer.customer;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepositry extends JpaRepository<Customer, Integer> {
}
