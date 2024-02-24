package com.example.ProteinApp.service;

import java.util.List;
import java.util.Optional;

import com.example.ProteinApp.entities.Product;


public interface IproductService {
        Product saveProduct(Product prod);

        List<Product> findAllProducts();

        Optional<Product> findById(Long id);

        void deleteProduct(Product product);

        List<Product> findProductsByName(String name);
        List<Product> filterProductsByPrice(double minPrice, double maxPrice);
}
