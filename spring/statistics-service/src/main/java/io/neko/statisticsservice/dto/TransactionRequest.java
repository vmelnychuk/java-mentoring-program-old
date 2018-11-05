package io.neko.statisticsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransactionRequest {
    private final double amount;
    private final long timestamp;
}
