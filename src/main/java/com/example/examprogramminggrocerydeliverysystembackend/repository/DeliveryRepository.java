package com.example.examprogramminggrocerydeliverysystembackend.repository;

import com.example.examprogramminggrocerydeliverysystembackend.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//TASK 1
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    List<Delivery> findAllByFromWarehouse(String warehouse);
}
