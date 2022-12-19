package com.example.examprogramminggrocerydeliverysystembackend.controller;

import com.example.examprogramminggrocerydeliverysystembackend.exception.ProductOrderIdNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.exception.ProductOrdersFromWarehouseNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.exception.ProductOrdersNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.model.Delivery;
import com.example.examprogramminggrocerydeliverysystembackend.model.Product;
import com.example.examprogramminggrocerydeliverysystembackend.model.ProductOrder;
import com.example.examprogramminggrocerydeliverysystembackend.model.Van;
import com.example.examprogramminggrocerydeliverysystembackend.repository.DeliveryRepository;
import com.example.examprogramminggrocerydeliverysystembackend.repository.ProductOrderRepository;
import com.example.examprogramminggrocerydeliverysystembackend.repository.ProductRepository;
import com.example.examprogramminggrocerydeliverysystembackend.repository.VanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//TASK 3 - List of Deliveries including ProductOrders - DONE (Tested on Postman)
@CrossOrigin
@RestController
public class ProductOrderController {

    @Autowired
    ProductOrderRepository productOrderRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    VanRepository vanRepository;

    //Done (Tested on postman)
    @GetMapping("/productOrders")
    public List<ProductOrder> getProductOrders() {
        List<ProductOrder> productOrders = productOrderRepository.findAllByOrderByDeliveryDeliveryId();

        if (productOrders.isEmpty()) {
            throw new ProductOrdersNotFoundException();
        } else {
            return productOrders;
        }
    }

    //Done (Tested on postman)
    @GetMapping("/productOrder/{id}")
    public ProductOrder getProductOrderById(@PathVariable("id") int id) {
        Optional<ProductOrder> productOrder = productOrderRepository.findById(id);

        if (productOrder.isPresent()) {
            return productOrder.get();
        } else {
            throw new ProductOrderIdNotFoundException(id);
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

    //Done (Tested on postman)
    @PostMapping("/productOrder")
    public ProductOrder createProductOrder(@RequestBody ProductOrder productOrder) {

        Optional<Van> van = vanRepository.findById(productOrder.getDelivery().getVan().getVanId());

        if (van.isPresent()) {

            Delivery delivery = new Delivery(productOrder.getDelivery().getDeliveryDate(), productOrder.getDelivery().getFromWarehouse(), productOrder.getDelivery().getDestination(), van.get());
            deliveryRepository.save(delivery);
            Optional<Product> product = productRepository.findById(productOrder.getProduct().getProductId());

            if (product.isPresent()) {
                ProductOrder newProductOrder = new ProductOrder(productOrder.getQuantity(), delivery, product.get());
                productOrderRepository.save(newProductOrder);
                return newProductOrder;
            }
        }
        return null;
    }

}
