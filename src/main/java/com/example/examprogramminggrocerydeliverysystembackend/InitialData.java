package com.example.examprogramminggrocerydeliverysystembackend;

import com.example.examprogramminggrocerydeliverysystembackend.model.Delivery;
import com.example.examprogramminggrocerydeliverysystembackend.model.Product;
import com.example.examprogramminggrocerydeliverysystembackend.model.ProductOrder;
import com.example.examprogramminggrocerydeliverysystembackend.model.Van;
import com.example.examprogramminggrocerydeliverysystembackend.repository.DeliveryRepository;
import com.example.examprogramminggrocerydeliverysystembackend.repository.ProductOrderRepository;
import com.example.examprogramminggrocerydeliverysystembackend.repository.ProductRepository;
import com.example.examprogramminggrocerydeliverysystembackend.repository.VanRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class InitialData {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    VanRepository vanRepository;

    @PostConstruct
    public void initializeData(){

        //Product
        Product p1 = new Product("Soda", 12, 200);
        Product p2 = new Product("Milk", 7, 1000);
        Product p3 = new Product("Chips", 10, 150);
        Product p4 = new Product("Eggs", 8, 200);
        Product p5 = new Product("Bread", 4, 100);
        Product p6 = new Product("For testing", 0, 0);

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);
        productRepository.save(p5);
        productRepository.save(p6);

        //Van
        Van v1 = new Van("Hyunday", "Entourage",2000);
        Van v2 = new Van("Isuzu", "Oasis",3000);
        Van v3 = new Van("Iveco", "Daily",2500);
        Van v4 = new Van("Jeep", "Fleetvan",4000);

        vanRepository.save(v1);
        vanRepository.save(v2);
        vanRepository.save(v3);
        vanRepository.save(v4);

        //Delivery - Names and Addresses generated randomly online
        Delivery d1 = new Delivery(LocalDate.of(2022,12,19), "W1", "Lucas Jansson, Egev??nget 75, 6660", v4);
        Delivery d2 = new Delivery(LocalDate.of(2022,12,20), "W2", "William Wikstr??m, Ladbyvej 34, 5883", v3);
        Delivery d3 = new Delivery(LocalDate.of(2022,12,21), "W3", "Camilla Lundqvist, Nordre Ringvej 70, 1735", v1);
        Delivery d4 = new Delivery(LocalDate.of(2022,12,22), "W3", "Vilma Holm, M??llebakken 73, 6840", v2);
        Delivery d5 = new Delivery(LocalDate.of(2022,12,23), "W1", "Mads S??rensen, Bygmestervej 82, 1592", v1);

        deliveryRepository.save(d1);
        deliveryRepository.save(d2);
        deliveryRepository.save(d3);
        deliveryRepository.save(d4);
        deliveryRepository.save(d5);

        //ProductOrder
        ProductOrder po5 = new ProductOrder(7,d5,p5);
        ProductOrder po2 = new ProductOrder(15,d2,p2);
        ProductOrder po1 = new ProductOrder(10,d1,p1);
        ProductOrder po3 = new ProductOrder(2,d3,p3);
        ProductOrder po4 = new ProductOrder(7,d4,p4);

        productOrderRepository.save(po5);
        productOrderRepository.save(po2);
        productOrderRepository.save(po3);
        productOrderRepository.save(po1);
        productOrderRepository.save(po4);

    }
}
