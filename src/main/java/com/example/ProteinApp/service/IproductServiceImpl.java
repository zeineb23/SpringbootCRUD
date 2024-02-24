package com.example.ProteinApp.service;

import com.example.ProteinApp.entities.Product;
import com.example.ProteinApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IproductServiceImpl implements IproductService {

    @Autowired
    private ProductRepository prodRepository;

    @Override
    public Product saveProduct(Product product) {
        return prodRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return prodRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return prodRepository.findById(id);
    }

    @Override
    public void deleteProduct(Product product) {
        prodRepository.delete(product);
    }

    @Override
    public List<Product> findProductsByName(String name) {
        return prodRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> filterProductsByPrice(double minPrice, double maxPrice) {
        return prodRepository.findByPriceBetween(minPrice, maxPrice);
    }
}

