package com.example.examprogramminggrocerydeliverysystembackend.controller;

import com.example.examprogramminggrocerydeliverysystembackend.exception.DeliveriesNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.model.Delivery;
import com.example.examprogramminggrocerydeliverysystembackend.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//TASK 3
@CrossOrigin
@RestController
public class DeliveryController {

    @Autowired
    DeliveryRepository deliveryRepository;

    //TASK 3 - List of Deliveries - Done (tested on Postman)
    @GetMapping("/deliveries")
    public List<Delivery> getDeliveries(){
        List<Delivery> deliveries = deliveryRepository.findAll();

        if (deliveries.isEmpty()){
            throw  new DeliveriesNotFoundException();
        } else {
            return deliveries;
        }
    }

    //TASK 3 - Create New Delivery - Done (tested on Postman)
    @PostMapping("/delivery")
    public Delivery createDelivery(@RequestBody Delivery delivery){

        Delivery newDelivery = new Delivery(delivery.getDeliveryDate(), delivery.getFromWarehouse(), delivery.getDestination());
        return deliveryRepository.save(newDelivery);
    }
}
