package com.example.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    private String name;

    private String category;

    private String imageUrl;

    @Column(length = 1000)
    private String description;
}
