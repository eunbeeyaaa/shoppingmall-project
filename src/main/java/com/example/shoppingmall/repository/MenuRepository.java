package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByCategory(String category);
    Optional<Menu> findByCategoryAndId(String category, Long id);
}
