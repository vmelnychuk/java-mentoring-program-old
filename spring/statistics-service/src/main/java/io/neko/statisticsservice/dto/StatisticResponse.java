package io.neko.statisticsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StatisticResponse {
    private final double sum;
    private final double avg;
    private final double max;
    private final double min;
    private final long count;
}
