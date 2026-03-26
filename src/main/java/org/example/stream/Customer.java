package org.example.stream;

import java.time.LocalDate;
import java.util.List;

public record Customer(
        String name,
        String city,
        Status status,
        double balance,
        LocalDate registrationDate,
        List<Card> cards
) {}