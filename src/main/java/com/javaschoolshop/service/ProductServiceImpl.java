package com.javaschoolshop.service;

import com.javaschoolshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaschoolshop.dao.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {

    private final List<Product> products;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.products = new ArrayList<>();
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.orElse(null);
    }

    /*
    @Override
    public Product addProduct(Product product) {

        return productRepository.save(product);
    }*/

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
