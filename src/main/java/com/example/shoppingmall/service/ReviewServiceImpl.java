package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Menu;
import com.example.shoppingmall.entity.Review;
import com.example.shoppingmall.repository.MenuRepository;
import com.example.shoppingmall.repository.ReviewRepository;
import com.example.shoppingmall.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Review> getReviewsByMenu(Long menuId) {
        return reviewRepository.findByMenuId(menuId);
    }

    @Override
    public void saveReview(ReviewRequest request) {
        Menu menu = menuRepository.findById(request.getMenuId())
                .orElseThrow(() -> new NoSuchElementException("메뉴 없음!"));

        Review review = new Review();
        review.setContent(request.getContent());
        review.setMemberName(request.getMemberName());
        review.setGender(request.getGender());
        review.setSize(request.getSize());
        review.setHeight(request.getHeight());
        review.setWeight(request.getWeight());
        review.setMenu(menu);
        review.setCreatedAt(LocalDateTime.now());
        reviewRepository.save(review);
    }
}