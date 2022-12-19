package com.example.examprogramminggrocerydeliverysystembackend.controller;

import com.example.examprogramminggrocerydeliverysystembackend.exception.ProductOrdersFromWarehouseNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.exception.ProductOrdersNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.model.ProductOrder;
import com.example.examprogramminggrocerydeliverysystembackend.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TASK 3 - List of Deliveries including ProductOrders - DONE (Tested on Postman)
@CrossOrigin
@RestController
public class ProductOrderController {

    @Autowired
    ProductOrderRepository productOrderRepository;

    @GetMapping("/productOrders")
    public List<ProductOrder> getProductOrders() {
        List<ProductOrder> productOrders = productOrderRepository.findAllByOrderByDeliveryDeliveryId();

        if (productOrders.isEmpty()) {
            throw new ProductOrdersNotFoundException();
        } else {
            return productOrders;
        }
    }

    //TASK 3 - Find Specific Delivery - Done (Tested on postman)
    @GetMapping("/productOrders/{warehouse}")
    public List<ProductOrder> getProductOrdersByWarehouse(@PathVariable("warehouse") String warehouse) {

        List<ProductOrder> productOrders = productOrderRepository.findAllByDeliveryFromWarehouse(warehouse);

        if (productOrders.isEmpty()) {
            throw new ProductOrdersFromWarehouseNotFoundException(warehouse);
        } else {
            return productOrders;
        }
    }


}
