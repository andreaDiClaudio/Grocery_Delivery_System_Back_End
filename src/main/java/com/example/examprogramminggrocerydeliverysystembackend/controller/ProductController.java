package com.example.examprogramminggrocerydeliverysystembackend.controller;

import com.example.examprogramminggrocerydeliverysystembackend.exception.ProductNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.exception.ProductsNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.model.Product;
import com.example.examprogramminggrocerydeliverysystembackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    //TASK 2 - List all Products
    @GetMapping("/products")
    public List<Product> getProducts() {

        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            throw new ProductsNotFoundException();
        } else {
            return products;
        }
    }

    //TASK 2 - Find a specific Product
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException(id);
        }
    }

    //TASK 2 - Add a Product
    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {

        Product newProduct = new Product(product.getName(), product.getPrice(), product.getWeight());
        return productRepository.save(newProduct);
    }
}

