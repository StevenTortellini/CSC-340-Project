package com.youselldatabase.youselldatabase.service;

import com.youselldatabase.youselldatabase.entities.Report;
import com.youselldatabase.youselldatabase.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository repo;

    public List<Report> getAllReports(){
        return repo.findAll();
    }

    public Report getReportById(int listId){
        return repo.findById(listId).orElse(null);
    }

    public void addNewReport(Report report){
        repo.save(report);
    }

    public void updateReport(int id, @org.jetbrains.annotations.NotNull Report report){
        Report existing = getReportById(id);
        existing.setReportHeading(report.getReportHeading());
        existing.setReportDes(report.getReportDes());
        existing.setReportStatus(report.getReportStatus());
        existing.setListingId(report.getListingId());
        repo.save(existing);
    }

    public List<Report> deleteReportById(int id){
        repo.deleteById(id);
        return repo.findAll();
    }





}
