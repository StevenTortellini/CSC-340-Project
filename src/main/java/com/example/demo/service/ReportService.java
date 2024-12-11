package com.example.demo.service;

import com.example.demo.model.Report;
import com.example.demo.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report createReport(String title, String description, String username) {
        Report report = new Report();
        report.setTitle(title);
        report.setDescription(description);
        report.setUsername(username);
        report.setStatus("Pending");
        return reportRepository.save(report);
    }
}

