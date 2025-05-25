package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Review;
import com.example.shoppingmall.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewsByMenu(Long menuId);
    void saveReview(ReviewRequest request);
}