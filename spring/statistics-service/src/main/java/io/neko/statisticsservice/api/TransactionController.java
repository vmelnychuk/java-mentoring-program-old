package io.neko.statisticsservice.api;

import io.neko.statisticsservice.dto.TransactionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @PostMapping
    public ResponseEntity<?> addTransaction(@RequestBody TransactionRequest transactionRequest) {
        long timestamp = transactionRequest.getTimestamp();

        if (withinPeriod(timestamp)) {
            return ResponseEntity.created(URI.create("")).build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    private boolean withinPeriod(long timestamp) {
        if (timestamp == 0) {
            return false;
        } else {
            return true;
        }
    }
}
