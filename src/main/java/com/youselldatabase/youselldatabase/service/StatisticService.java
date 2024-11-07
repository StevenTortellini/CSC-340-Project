package com.youselldatabase.youselldatabase.service;


import com.youselldatabase.youselldatabase.entities.Statistic;
import com.youselldatabase.youselldatabase.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatisticService {
    @Autowired
    private StatisticRepository repo;

    public List<Statistic> getAllStatistics(){
        return repo.findAll();
    }

    public Statistic getStatisticById(int listId){
        return repo.findById(listId).orElse(null);
    }

    public void addNewStatistic(Statistic statistic){
        repo.save(statistic);
    }

    public void updateStatistic(int id, @org.jetbrains.annotations.NotNull Statistic statistic){
        repo.save(statistic);
    }

    public List<Statistic> deleteStatisticById(int id){
        repo.deleteById(id);
        return repo.findAll();
    }

}
