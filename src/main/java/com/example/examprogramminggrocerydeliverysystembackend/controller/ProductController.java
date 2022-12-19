package com.example.examprogramminggrocerydeliverysystembackend.controller;

import com.example.examprogramminggrocerydeliverysystembackend.exception.ProductNameNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.exception.ProductNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.exception.ProductsNotFoundException;
import com.example.examprogramminggrocerydeliverysystembackend.model.Product;
import com.example.examprogramminggrocerydeliverysystembackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    //TASK 2 - List all Products - DONE (Tested on Postman)
    @GetMapping("/products")
    public List<Product> getProducts() {

        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            throw new ProductsNotFoundException();
        } else {
            return products;
        }
    }

    //TASK 2 - Find a specific Product - DONE (Tested on Postman)
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException(id);
        }
    }

    //TASK 2 - Find a Product By Name  - DONE (Tested on Postman)
    @GetMapping("/productName/{name}")
    public Product getProductByName(@PathVariable("name") String name){

        Optional<Product> product = productRepository.findByName(name);

        if (product.isPresent()){
            return product.get();
        } else {
            throw new ProductNameNotFoundException(name);
        }
    }

    //TASK 2 - Add a Product - DONE (Tested on Postman)
    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {

        Product newProduct = new Product(product.getName(), product.getPrice(), product.getWeight());
        return productRepository.save(newProduct);
    }

    //TASK 2 - Edit a Product - DONE (Tested on Postman)
    @PutMapping("/editProduct/{id}")
    public Product editProduct(@RequestBody Product inputtedProduct, @PathVariable("id") int id){
        return productRepository.findById(id)
                .map(product -> {

                    product.setName(inputtedProduct.getName());
                    product.setPrice(inputtedProduct.getPrice());
                    product.setWeight(inputtedProduct.getWeight());

                    return productRepository.save(product);
                }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    //TASK 2 - Delete a Product - DONE (Tested on Postman)
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){

        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ResponseEntity<>("Product with id: '" + id + "' deleted correctly!", HttpStatus.OK);
        } else {
            throw new ProductNotFoundException(id);
        }
    }
}

