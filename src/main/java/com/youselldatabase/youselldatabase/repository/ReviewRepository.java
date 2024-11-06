package com.youselldatabase.youselldatabase.repository;

import com.youselldatabase.youselldatabase.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Integer> {
}