package com.example.demo.repository;

import com.example.demo.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Integer> {
    @Query(value = "SELECT * FROM listings l WHERE l.name LIKE %?1%", nativeQuery = true)
    List<Listing> findListingsByNameMatching(String name);
}
