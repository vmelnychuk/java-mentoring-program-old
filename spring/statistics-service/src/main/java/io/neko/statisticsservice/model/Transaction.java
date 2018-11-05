package io.neko.statisticsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@Getter
public class Transaction {
    private final BigDecimal amount;
    private final Instant timestamp;
}
