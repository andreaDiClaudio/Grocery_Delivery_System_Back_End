package com.example.examprogramminggrocerydeliverysystembackend.repository;

import com.example.examprogramminggrocerydeliverysystembackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//TASK 1
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);
}
