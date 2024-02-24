package com.example.ProteinApp.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.validation.Valid;

import com.example.ProteinApp.entities.Product;
import com.example.ProteinApp.service.IproductService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/protein")
public class ProductController {

    @Autowired
    private IproductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @PostMapping("/addproduct")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
        @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productService.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        final Product updatedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        Product product = productService.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productService.deleteProduct(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    // Existing endpoints for getting all products and adding a new product

    @GetMapping("/products/{name}")
    public ResponseEntity<List<Product>> searchProductsByName(@PathVariable String name) {
        List<Product> products = productService.findProductsByName(name);
        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/filter")
    public ResponseEntity<List<Product>> filterProductsByPrice(@RequestParam("minPrice") double minPrice,
                                                               @RequestParam("maxPrice") double maxPrice) {
        List<Product> products = productService.filterProductsByPrice(minPrice, maxPrice);
        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

