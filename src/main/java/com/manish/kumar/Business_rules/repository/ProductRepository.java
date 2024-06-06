package com.manish.kumar.Business_rules.repository;


import com.manish.kumar.Business_rules.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
