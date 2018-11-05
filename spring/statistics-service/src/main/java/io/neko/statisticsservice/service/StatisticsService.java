package io.neko.statisticsservice.service;

import io.neko.statisticsservice.model.Statistic;
import io.neko.statisticsservice.model.Transaction;

public interface StatisticsService {
    void addTransaction(Transaction transaction);
    Statistic getStatistics();
}
