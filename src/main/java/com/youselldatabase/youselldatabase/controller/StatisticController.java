// src/main/java/com/youselldatabase/youselldatabase/controller/ListingController.java
package com.youselldatabase.youselldatabase.controller;

import com.youselldatabase.youselldatabase.entities.Listing;
import com.youselldatabase.youselldatabase.entities.Statistic;
import com.youselldatabase.youselldatabase.repository.ListingRepository;
import com.youselldatabase.youselldatabase.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatisticController {

    @Autowired
    private StatisticService service;

    @GetMapping("/all")
    public List<Statistic> getAllStatistics() {
        return service.getAllStatistics();
    }

    @GetMapping("/{id}")
    public Statistic getStatisticById(@PathVariable int id) {
        return service.getStatisticById(id);
    }

    @PostMapping("/new")
    public List<Statistic> createStatistic(@RequestBody Statistic statistic) {
        service.addNewStatistic(statistic);
        return service.getAllStatistics();
    }

    @PutMapping("/update/{id}")
    public Statistic updateStatistic(@PathVariable int id, @RequestBody Statistic statisticDetails) {
        service.updateStatistic(id, statisticDetails);
        return getStatisticById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStatistic(@PathVariable int id) {
        service.deleteStatisticById(id);
    }
}