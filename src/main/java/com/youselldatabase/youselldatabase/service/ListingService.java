package com.youselldatabase.youselldatabase.service;

import com.youselldatabase.youselldatabase.entities.Listing;

import com.youselldatabase.youselldatabase.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListingService {

    @Autowired
    private ListingRepository repo;

    public List<Listing> getAllListings(){
        return repo.findAll();
    }

    public  Listing getListingById(int listId){
        return repo.findById(listId).orElse(null);
    }

    public void addNewListing(Listing listing){
        repo.save(listing);
    }

    public void updateListing(int id, @org.jetbrains.annotations.NotNull Listing listing){
       Listing  existing = getListingById(id);
        existing.setListedAt(listing.getListedAt());
        existing.setListingDes(listing.getListingDes());
        existing.setListingName(listing.getListingName());
        existing.setListingStatus(listing.getListingStatus());
        existing.setCreatedBy(listing.getCreatedBy());
        existing.setSoldTo(listing.getSoldTo());

        repo.save(existing);

    }

    public List<Listing> deleteListingById(int id){
        repo.deleteById(id);
        return  repo.findAll();
    }



}
