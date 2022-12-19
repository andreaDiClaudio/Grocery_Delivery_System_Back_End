package com.example.examprogramminggrocerydeliverysystembackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//TASK 1
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productOrderId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "delivery", foreignKey = @ForeignKey(name = "fk_delivery_id"))
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "product", foreignKey = @ForeignKey(name = "fk_product_id"))
    private Product product;

    public ProductOrder(int quantity, Delivery delivery, Product product) {
        this.quantity = quantity;
        this.delivery = delivery;
        this.product = product;
    }
}
