package com.example.invoice.repositories;

import com.example.invoice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findAllByOrderByIdDesc();
}
