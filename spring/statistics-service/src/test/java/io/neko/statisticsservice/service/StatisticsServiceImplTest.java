package io.neko.statisticsservice.service;

import io.neko.statisticsservice.model.Statistic;
import io.neko.statisticsservice.model.Transaction;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.Assert.*;

public class StatisticsServiceImplTest {

    @Test
    public void testAddTransaction() {
        StatisticsService statisticsService = new StatisticsServiceImpl();
        Transaction transaction = new Transaction(new BigDecimal(0.22), Instant.now());
        statisticsService.addTransaction(transaction);
    }

    @Test
    public void testGetStatistics() {
        StatisticsService statisticsService = new StatisticsServiceImpl();
        Statistic statistic = statisticsService.getStatistics();
        assertNull(statistic);
    }

}
