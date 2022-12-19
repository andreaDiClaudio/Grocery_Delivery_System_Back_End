package com.example.examprogramminggrocerydeliverysystembackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Van {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vanId;

    private String brand;
    private String model;
    private int capacity;

    @OneToMany
    @JsonBackReference
    private Set<Delivery> deliveries = new HashSet<>();

    public Van(String brand,String model, int capacity) {
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
    }
}
