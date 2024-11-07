package com.youselldatabase.youselldatabase.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewId;
    private String reviewDes;
    private double rating;
    private int listingId;

    // Getters and Setters

    public String getReviewDes() {
        return reviewDes;
    }

    public void setReviewDes(String reviewDes) {
        this.reviewDes = reviewDes;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }
}