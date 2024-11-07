// src/main/java/com/youselldatabase/youselldatabase/controller/ListingController.java
package com.youselldatabase.youselldatabase.controller;

import com.youselldatabase.youselldatabase.entities.Listing;
import com.youselldatabase.youselldatabase.repository.ListingRepository;
import com.youselldatabase.youselldatabase.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private ListingService service;

    @GetMapping("/all")
    public List<Listing> getAllListings() {

        return service.getAllListings();
    }

    @GetMapping("/{id}")
    public Listing getListingById(@PathVariable int id) {

        return service.getListingById(id);
    }

    @PostMapping("/new")
    public Listing createListing(@RequestBody Listing listing) {
               service.addNewListing(listing);
       return getListingById(listing.getListingId());
    }

    @PutMapping("/update/{id}")
    public Listing updateListing(@PathVariable int id, @RequestBody Listing listingDetails) {
        service.updateListing(id,listingDetails);
        return getListingById(id);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteListing(@PathVariable int id) {

        service.deleteListingById(id);
    }
}