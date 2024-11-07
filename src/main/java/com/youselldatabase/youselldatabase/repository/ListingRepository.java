// src/main/java/com/youselldatabase/youselldatabase/repository/ListingRepository.java
package com.youselldatabase.youselldatabase.repository;

import com.youselldatabase.youselldatabase.entities.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface ListingRepository extends JpaRepository<Listing, Integer> {
}