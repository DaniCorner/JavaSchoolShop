package com.javaschoolshop.service;

import com.javaschoolshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
   // Product addProduct(Product product);
    void deleteProduct(Long id);
}

