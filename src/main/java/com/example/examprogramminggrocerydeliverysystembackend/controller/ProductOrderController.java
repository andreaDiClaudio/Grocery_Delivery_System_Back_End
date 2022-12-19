package com.example.examprogramminggrocerydeliverysystembackend.controller;

import com.example.examprogramminggrocerydeliverysystembackend.exception.ProductOrdersNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.model.ProductOrder;
import com.example.examprogramminggrocerydeliverysystembackend.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TASK 3 - List of Deliveries including ProductOrders
@CrossOrigin
@RestController
public class ProductOrderController {

    @Autowired
    ProductOrderRepository productOrderRepository;

    @GetMapping("/productOrders")
    public List<ProductOrder> getProductOrders() {
        List<ProductOrder> productOrders = productOrderRepository.findAll();

        if (productOrders.isEmpty()) {
            throw new ProductOrdersNotFoundException();
        } else {
            return productOrders;
        }
    }

}
