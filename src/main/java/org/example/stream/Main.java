package org.example.stream;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Customer>    customers    = TestData.customers();
        List<Transaction> transactions = TestData.transactions();

        System.out.println("=== Customers ===");
        customers.forEach(c ->
                System.out.printf("%-20s | %-10s | %-8s | %,10.0f AZN | Cards: %d%n",
                        c.name(), c.city(), c.status(), c.balance(), c.cards().size())
        );

        System.out.println("\n=== Transactions ===");
        transactions.forEach(t ->
                System.out.printf("%-8s | %-12s | %-14s | %-8s | %,8.0f %-3s | %s%n",
                        t.id(), t.cardNumber(), t.branch().split(" ")[0],
                        t.type(), t.amount(), t.currency(), t.date().toLocalDate())
        );

        // ── S1 starter ───────────────────────────────────────────
        System.out.println("\n=== S1: Active customers ===");
        customers.stream()
                .filter(c -> c.status() == Status.ACTIVE)
                .map(Customer::name)
                .sorted()
                .forEach(System.out::println);
    }
}