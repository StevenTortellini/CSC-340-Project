// src/main/java/com/youselldatabase/youselldatabase/controller/ListingController.java
package com.youselldatabase.youselldatabase.controller;

import com.youselldatabase.youselldatabase.entities.Listing;
import com.youselldatabase.youselldatabase.entities.Review;
import com.youselldatabase.youselldatabase.repository.ListingRepository;
import com.youselldatabase.youselldatabase.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return service.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable int id) {
        return service.getReviewById(id);
    }

    @PostMapping("/new")
    public Review createReview(@RequestBody Review review) {
        service.addNewReview(review);
        return getReviewById(review.getReviewId());
    }

    @PutMapping("/update/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review reviewDetails) {
        service.updateReview(id, reviewDetails);
        return getReviewById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        service.deleteReviewById(id);
    }
}