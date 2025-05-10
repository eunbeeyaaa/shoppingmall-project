package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product getProductDetail(String category, Long productId) {
        return productRepository.findByCategoryAndId(category, productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
    }
}
