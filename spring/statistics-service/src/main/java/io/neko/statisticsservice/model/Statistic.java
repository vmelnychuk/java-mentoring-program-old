package io.neko.statisticsservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class Statistic {
    private final BigDecimal totalSum;
    private final BigDecimal average;
    private final BigDecimal maximumAmount;
    private final BigDecimal minimumAmount;
    private final long count;

}
