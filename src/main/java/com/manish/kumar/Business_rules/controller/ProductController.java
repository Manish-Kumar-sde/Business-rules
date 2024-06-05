package com.manish.kumar.Business_rules.controller;

import com.manish.kumar.Business_rules.model.Product;
import com.manish.kumar.Business_rules.repository.ProductRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/v1/products",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveProduct(@RequestBody Product product){
        Product product1 = repository.save(product);
        return product1.toString();
    }

    @GetMapping("/v1/products/{id}")
    public Product getProduct(@PathVariable Integer id){
        return repository.findById(id).orElse(new Product());
    }
}
