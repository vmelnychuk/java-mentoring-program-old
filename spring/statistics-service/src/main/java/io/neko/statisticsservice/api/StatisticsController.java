package io.neko.statisticsservice.api;

import io.neko.statisticsservice.dto.StatisticResponse;
import io.neko.statisticsservice.model.Statistic;
import io.neko.statisticsservice.service.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getStatistics() {
        Statistic statistic = statisticsService.getStatistics();
        return new ResponseEntity<StatisticResponse>(new StatisticResponse(0,0,0,0,0L), HttpStatus.OK);
    }
}
