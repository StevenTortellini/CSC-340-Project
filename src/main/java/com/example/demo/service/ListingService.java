package com.example.demo.service;

import com.example.demo.model.Listing;
import com.example.demo.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Base64;
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

    public int createListing(Listing listing){
        repo.save(listing);
        return listing.getListingId();
    }

    public List<Listing> queryByUserId(int userId){
        return repo.queryByUserId(userId);
    }

    public void updateListing(int id,Listing listing){
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
