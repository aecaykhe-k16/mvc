package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;

import java.util.List;

public class ProductService {
    private  final ProductRepo productRepo;

    public ProductService() {
        productRepo = new ProductRepo();
    }

    public  void addProduct(Product product) {
        productRepo.create(product);
    }

    public  void updateProduct(Product product) {
        productRepo.update(product);
    }

    public  boolean removeProduct(String id) {
        return productRepo.delete(id);
    }

    public  Product findById(String id) {
        return productRepo.getOne(id);
    }

    public List<Product> getAllProducts() {
        return productRepo.getAll();
    }
}
