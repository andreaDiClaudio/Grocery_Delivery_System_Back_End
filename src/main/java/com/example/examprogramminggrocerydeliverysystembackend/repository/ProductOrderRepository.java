package com.example.examprogramminggrocerydeliverysystembackend.repository;

import com.example.examprogramminggrocerydeliverysystembackend.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

//TASK 1
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}
