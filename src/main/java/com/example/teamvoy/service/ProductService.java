package com.example.teamvoy.service;

import com.example.teamvoy.model.Product;

public interface ProductService {
    Product save(Product product);

    Product findById(Long id);
}
