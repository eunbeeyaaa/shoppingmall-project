package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Menu;
import com.example.shoppingmall.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private final MenuRepository menuRepository;

    @Autowired
    public ProductServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getProductsByCategory(String category) {
        return menuRepository.findByCategory(category);
    }

    @Override
    public Menu getProductDetail(String category, Long productId) {
        return menuRepository.findByCategoryAndId(category, productId)
                .orElseThrow(() -> new NoSuchElementException("Menu not found"));
    }

    @Override
    public Menu getProductById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Menu not found"));
    }
}
