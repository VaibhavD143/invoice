package com.example.invoice.controllers;

import com.example.invoice.models.Product;
import com.example.invoice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public String test(){
        return "Working...";
    }

    @GetMapping("/findAll")
    public List<Product> findAllProducts(){
        return productService.findAll();
    }

    @PostMapping("/update")
    public Product update(@RequestBody Product product){
        return productService.save(product);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        System.out.println(product.toString());
        return productService.save(product);
    }
}
