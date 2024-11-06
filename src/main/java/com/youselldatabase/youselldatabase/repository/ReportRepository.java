package com.youselldatabase.youselldatabase.repository;

import com.youselldatabase.youselldatabase.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReportRepository extends JpaRepository<Report, Integer> {
}