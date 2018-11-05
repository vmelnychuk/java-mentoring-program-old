package io.neko.statisticsservice.service;

import io.neko.statisticsservice.model.Statistic;
import io.neko.statisticsservice.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Override
    public void addTransaction(Transaction transaction) {
    }

    @Override
    public Statistic getStatistics() {
        return null;
    }
}
