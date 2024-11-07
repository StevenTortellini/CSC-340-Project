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

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getSoldListings() {
        return soldListings;
    }

    public void setSoldListings(int soldListings) {
        this.soldListings = soldListings;
    }

    public int getActiveTickets() {
        return activeTickets;
    }

    public void setActiveTickets(int activeTickets) {
        this.activeTickets = activeTickets;
    }

    public int getFulfiledTickets() {
        return fulfiledTickets;
    }

    public void setFulfiledTickets(int fulfiledTickets) {
        this.fulfiledTickets = fulfiledTickets;
    }

    public int getTotalListings() {
        return totalListings;
    }

    public void setTotalListings(int totalListings) {
        this.totalListings = totalListings;
    }
}