// src/main/java/com/youselldatabase/youselldatabase/entities/Listing.java
package com.youselldatabase.youselldatabase.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int listingId;

    @Column(nullable = false)
    private String listingName;

    @Column(nullable = false)
    private String listingDes;

    @Column(nullable = false)
    private String listingStatus;

    @Column(nullable = false)
    private Date listedAt;

    @Column(nullable = false)
    private int createdBy;


    private Integer soldTo;

    // Getters and Setters
    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

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

    public String getListingStatus() {
        return listingStatus;
    }

    public void setListingStatus(String listingStatus) {
        this.listingStatus = listingStatus;
    }

    public Date getListedAt() {
        return listedAt;
    }

    public void setListedAt(Date listedAt) {
        this.listedAt = listedAt;
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
}