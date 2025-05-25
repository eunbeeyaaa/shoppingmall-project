package com.example.shoppingmall.request;

import lombok.Data;

@Data
public class CartRequest {
    private Long menuId;
    private int quantity;
    private String color;
    private String size;
}
