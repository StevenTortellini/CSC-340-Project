package com.youselldatabase.youselldatabase.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reportId;
    private String reportHeading;
    private String reportDes;
    private String reportStatus;
    private int listingId;

    // Getters and Setters

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportHeading() {
        return reportHeading;
    }

    public void setReportHeading(String reportHeading) {
        this.reportHeading = reportHeading;
    }

    public String getReportDes() {
        return reportDes;
    }

    public void setReportDes(String reportDes) {
        this.reportDes = reportDes;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }
}