package org.example.stream;

public record Card(
        String number,
        CardType type,
        double limit,
        boolean active
) {}