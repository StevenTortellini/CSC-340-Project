package com.youselldatabase.youselldatabase.repository;

import com.youselldatabase.youselldatabase.entities.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
}