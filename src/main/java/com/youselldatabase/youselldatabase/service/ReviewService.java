package com.youselldatabase.youselldatabase.service;


import com.youselldatabase.youselldatabase.entities.Review;
import com.youselldatabase.youselldatabase.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repo;

    public List<Review> getAllReviews(){
        return repo.findAll();
    }

    public Review getReviewById(int listId){
        return repo.findById(listId).orElse(null);
    }

    public void addNewReview(Review review){
        repo.save(review);
    }

    public void updateReview(int id, @org.jetbrains.annotations.NotNull Review review){


        repo.save(review);
    }

    public List<Review> deleteReviewById(int id){
        repo.deleteById(id);
        return repo.findAll();
    }

}
