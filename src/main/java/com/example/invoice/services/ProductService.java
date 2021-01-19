package com.example.invoice.services;


import com.example.invoice.models.Product;
import com.example.invoice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product save(Product product){
        System.out.println(product.toString());
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAllByOrderByIdDesc();
    }

    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }
}
