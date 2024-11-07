// src/main/java/com/youselldatabase/youselldatabase/controller/ListingController.java
package com.youselldatabase.youselldatabase.controller;

import com.youselldatabase.youselldatabase.entities.Listing;
import com.youselldatabase.youselldatabase.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private ListingRepository listingRepository;

    @GetMapping
    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Listing getListingById(@PathVariable int id) {
        return listingRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Listing createListing(@RequestBody Listing listing) {
        return listingRepository.save(listing);
    }

    @PutMapping("/{id}")
    public Listing updateListing(@PathVariable int id, @RequestBody Listing listingDetails) {
        Listing listing = listingRepository.findById(id).orElse(null);
        if (listing != null) {
            listing.setListingName(listingDetails.getListingName());
            listing.setListingDes(listingDetails.getListingDes());
            listing.setListingStatus(listingDetails.getListingStatus());
            listing.setListedAt(listingDetails.getListedAt());
            listing.setCreatedBy(listingDetails.getCreatedBy());
            listing.setSoldTo(listingDetails.getSoldTo());
            return listingRepository.save(listing);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteListing(@PathVariable int id) {
        listingRepository.deleteById(id);
    }
}