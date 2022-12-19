package com.example.examprogramminggrocerydeliverysystembackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//TASK 1
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;
    private String fromWarehouse; //name of the warehouse
    private String destination; //address of the customer

    @OneToMany
    @JsonBackReference
    private Set<ProductOrder> productOrders = new HashSet<>();

    public Delivery(LocalDate deliveryDate, String fromWarehouse, String destination) {
        this.deliveryDate = deliveryDate;
        this.fromWarehouse = fromWarehouse;
        this.destination = destination;
    }
}
