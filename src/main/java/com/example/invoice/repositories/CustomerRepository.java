package com.example.invoice.repositories;

import com.example.invoice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer ,Integer> {
}
