package com.sharedcart.backend.controller;

import com.sharedcart.backend.model.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Also allow frontend from file:// or localhost:5500
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    public ProductController() {
        // Sample products for testing
        products.add(new Product(1L, "Toothpaste", "Fresh minty gel", 30.0,
                "https://via.placeholder.com/150", "home"));
        products.add(new Product(2L, "Notebook", "200 pages ruled", 60.0,
                "https://via.placeholder.com/150", "stationery"));
        products.add(new Product(3L, "Water Bottle", "1L Steel Bottle", 150.0,
                "https://via.placeholder.com/150", "home"));
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        products.add(product);
        return ResponseEntity.ok("✅ Product added!");
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/test")
    public String test() {
        return "✅ Hello from product controller!";
    }
}
