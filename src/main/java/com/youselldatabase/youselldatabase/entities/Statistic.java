package com.youselldatabase.youselldatabase.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Statistic {
    @Id
    private int totalTickets;
    private int activeTickets;
    private int fulfiledTickets;
    private int totalListings;
    private int soldListings;

    // Getters and Setters
}