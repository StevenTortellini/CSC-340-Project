package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public String getAllListings(Model model) {
        model.addAttribute("listingList", listingService.getAllListings());
        return "listings";
    }

    @GetMapping("/listingId/{id}/userId/{userId}")
    public String getListingById(@PathVariable int listingId, @PathVariable int userId, Model model) {
        model.addAttribute("listing", listingService.getListingById(listingId));
        model.addAttribute("user", userService.getUserByUserId(userId));
        return "indivListing";
    }

    @GetMapping("/createForm")
    public String listingForm(Model model) {
        Listing newListing = new Listing();
        int id = newListing.getUserId();
        newListing.setStatus(0);
        model.addAttribute("listing", newListing);
        model.addAttribute("user", id);
        return "sellpage";
    }

    //@RequestParam("productImage") MultipartFile productImage
    @PostMapping("/new")
    public String createListing(@ModelAttribute("listing") Listing listing) {
        User user = userService.getUserByUserId(1);
        if (user == null) {
            throw new IllegalArgumentException("User not found for ID: " + listing.getUserId());
        }
        listing.setUsername(user.getUsername());
        int listingId = listingService.createListing(listing);
        return "listings";
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("listing", listingService.getListingById(id));
        return "listing";
    }

    @PostMapping("/update")
    public String updateListing(Listing listing) {
        listingService.updateListing(listing.getListingId(), listing);
        return "redirect:/listings/" + listing.getListingId();
    }

    @GetMapping("/delete/{id}")
    public String deleteListingById(@PathVariable int id) {
        listingService.deleteListingById(id);
        return "redirect:/listings/all";
    }
}
