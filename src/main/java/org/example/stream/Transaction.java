package org.example.stream;

import java.time.LocalDateTime;

public record Transaction(
        String id,
        String cardNumber,
        String branch,
        TransactionType type,
        Currency currency,
        double amount,
        String country,
        LocalDateTime date
) {}