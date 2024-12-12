// src/main/java/com/youselldatabase/youselldatabase/entities/Listing.java
package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int listingId;

    private int userId;

    private int status; // 0 = Not Sold 1 = Sold

    private String username;

    @Column(nullable = false)
    private String listingName;

    @Column(nullable = false)
    private String listingDes;

    @Column(nullable = false)
    private Double listingPrice;

    @Column(nullable = false)
    private String listingStatus;

    @Column(nullable = false)
    private LocalDateTime listedAt;


    @Column(nullable = false)
    private int createdBy;

    @Column(columnDefinition = "BLOB")
    private byte[] imageData;


    private Integer soldTo;

    // Getters and Setters
    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public int getUserId() {return userId;}

    public void setUserId(int userId){ this.userId = userId;}

    public int getStatus() { return status;}

    public void setStatus(int status) {this.status = status;}

    public String getUsername(){ return username;}

    public void setUsername(String username){ this.username = username;}

    public String getListingName() {
        return listingName;
    }

    public void setListingName(String listingName) {
        this.listingName = listingName;
    }

    public String getListingDes() {
        return listingDes;
    }

    public void setListingDes(String listingDes) {
        this.listingDes = listingDes;
    }

    public Double getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(Double listingPrice) {
        this.listingPrice = listingPrice;
    }

    public String getListingStatus() {
        return listingStatus;
    }

    public void setListingStatus(String listingStatus) {
        this.listingStatus = listingStatus;
    }

    public LocalDateTime getListedAt() {
        return listedAt;
    }

    public void setListedAt(LocalDateTime listedAt) {
        this.listedAt = LocalDateTime.now();
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getSoldTo() {
        return soldTo;
    }

    public void setSoldTo(Integer soldTo) {
        this.soldTo = soldTo;
    }

    public byte[] getImageData() { return imageData; }

    public void setImageData(byte[] imageData) { this.imageData = imageData; }


}

