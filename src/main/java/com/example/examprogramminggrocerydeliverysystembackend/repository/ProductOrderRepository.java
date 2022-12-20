package com.example.examprogramminggrocerydeliverysystembackend.repository;

import com.example.examprogramminggrocerydeliverysystembackend.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//TASK 1
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    List<ProductOrder> findAllByOrderByDeliveryDeliveryId();

    List<ProductOrder> findAllByDeliveryFromWarehouse(String warehouse);

}
