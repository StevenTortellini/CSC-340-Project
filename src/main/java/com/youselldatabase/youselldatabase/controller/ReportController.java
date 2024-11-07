// src/main/java/com/youselldatabase/youselldatabase/controller/ListingController.java
package com.youselldatabase.youselldatabase.controller;

import com.youselldatabase.youselldatabase.entities.Listing;
import com.youselldatabase.youselldatabase.entities.Report;
import com.youselldatabase.youselldatabase.repository.ListingRepository;
import com.youselldatabase.youselldatabase.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService service;

    @GetMapping("/all")
    public List<Report> getAllReports() {
        return service.getAllReports();
    }

    @GetMapping("/{id}")
    public Report getReportById(@PathVariable int id) {
        return service.getReportById(id);
    }

    @PostMapping("/new")
    public Report createReport(@RequestBody Report report) {
        service.addNewReport(report);
        return getReportById(report.getReportId());
    }

    @PutMapping("/update/{id}")
    public Report updateReport(@PathVariable int id, @RequestBody Report reportDetails) {
        service.updateReport(id, reportDetails);
        return getReportById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable int id) {
        service.deleteReportById(id);
    }
}