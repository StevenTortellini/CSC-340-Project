package com.example.demo.controller;

import com.example.demo.model.Listing;
import com.example.demo.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;


    @GetMapping("/all")
    public String getAllListings(Model model) {
        model.addAttribute("listingList", listingService.getAllListings());
        return "listings";
    }

    @GetMapping("/{id}")
    public String getListingById(@PathVariable int id, Model model) {
        model.addAttribute("listing", listingService.getListingById(id));
        return "listings";
    }

    @GetMapping("/createForm")
    public String showCreateForm() {
        return "listings";
    }

    @PostMapping("/new")
    public String createListing(@ModelAttribute Listing listing, @RequestParam("productImage") MultipartFile productImage) {
        listingService.addNewListing(listing, productImage); // Service handles image saving
        System.out.println("Listing Name: " + listing.getListingName());
        System.out.println("Image File: " + productImage.getOriginalFilename());
        return "redirect:/listings/all";
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
