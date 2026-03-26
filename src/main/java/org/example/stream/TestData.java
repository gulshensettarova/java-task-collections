package org.example.stream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TestData {

    // ─────────────────────────────────────────────────────────────
    //  CUSTOMERS
    // ─────────────────────────────────────────────────────────────
    public static List<Customer> customers() {
        return List.of(

                new Customer("Gulshan Sattarova", "Nakchivan", Status.ACTIVE, 85_000,
                        LocalDate.of(2019, 3, 10),
                        List.of(
                                new Card("4169 1111", CardType.CREDIT, 10_000, true),
                                new Card("4169 1112", CardType.DEBIT,   5_000, false)
                        )),

                new Customer("Leyla Mammadova", "Barda", Status.ACTIVE, 12_500,
                        LocalDate.of(2021, 7, 22),
                        List.of(
                                new Card("4169 2221", CardType.DEBIT,  3_000, true),
                                new Card("4169 2222", CardType.CREDIT, 8_000, true)
                        )),

                new Customer("Gunay Niyazli", "Agstafa", Status.ACTIVE, 47_300,
                        LocalDate.of(2020, 1, 5),
                        List.of(
                                new Card("4169 3331", CardType.CREDIT, 15_000, false)
                        )),

                new Customer("Nigar Məmmədova", "Barda", Status.ACTIVE, 3_200,
                        LocalDate.of(2023, 11, 1),
                        List.of(
                                new Card("4169 4441", CardType.DEBIT, 2_000, true),
                                new Card("4169 4442", CardType.DEBIT, 2_000, true)
                        )),

                new Customer("Ali Babayev", "Baku", Status.ACTIVE, 91_000,
                        LocalDate.of(2018, 6, 14),
                        List.of(
                                new Card("4169 5551", CardType.CREDIT, 20_000, true)
                        )),

                new Customer("Səbinə Quliyeva", "Tovuz", Status.BLOCKED, 8_750,
                        LocalDate.of(2022, 4, 30),
                        List.of(
                                new Card("4169 6661", CardType.DEBIT, 5_000, false)
                        )),

                new Customer("Ali Hüseynov", "Lankaran", Status.ACTIVE, 29_400,
                        LocalDate.of(2020, 9, 18),
                        List.of(
                                new Card("4169 7771", CardType.CREDIT, 7_000, true),
                                new Card("4169 7772", CardType.DEBIT,  3_000, true)
                        )),

                new Customer("Aynur İsmayıl", "Baku", Status.ACTIVE, 55_600,
                        LocalDate.of(2017, 2, 28),
                        List.of(
                                new Card("4169 8881", CardType.CREDIT, 12_000, true)
                        )),

                new Customer("Ali Cəfərov", "Sumgait", Status.INACTIVE, 1_800,
                        LocalDate.of(2023, 8, 15),
                        List.of(
                                new Card("4169 9991", CardType.DEBIT, 1_000, false)
                        )),

                new Customer("Günel Rzayeva", "Baku", Status.ACTIVE, 38_200,
                        LocalDate.of(2021, 12, 3),
                        List.of(
                                new Card("4169 0001", CardType.DEBIT,   4_000, true),
                                new Card("4169 0002", CardType.CREDIT,  9_000, true)
                        ))
        );
    }

    // ─────────────────────────────────────────────────────────────
    //  TRANSACTIONS
    // ─────────────────────────────────────────────────────────────
    public static List<Transaction> transactions() {
        LocalDateTime now = LocalDateTime.now();

        return List.of(
                // Gulshan Sattarova — 4169 1111
                new Transaction("TRX001", "4169 1111", "Baku Main Branch",    TransactionType.CREDIT,   Currency.AZN,  4_500, "AZ", now.minusDays(2)),
                new Transaction("TRX002", "4169 1111", "Baku Main Branch",    TransactionType.DEBIT,    Currency.AZN,  1_200, "AZ", now.minusDays(1)),
                new Transaction("TRX003", "4169 1111", "Baku Main Branch",    TransactionType.TRANSFER, Currency.USD,  8_000, "US", now.minusHours(3)),
                new Transaction("TRX004", "4169 1111", "Baku Main Branch",    TransactionType.DEBIT,    Currency.AZN,    350, "AZ", now.minusHours(2)),
                new Transaction("TRX005", "4169 1111", "Baku Main Branch",    TransactionType.TRANSFER, Currency.EUR,  2_100, "DE", now.minusHours(1)),

                // Leyla Əliyeva — 4169 2221 / 2222
                new Transaction("TRX006", "4169 2221", "Ganja Branch",        TransactionType.DEBIT,    Currency.AZN,    780, "AZ", now.minusDays(5)),
                new Transaction("TRX007", "4169 2222", "Ganja Branch",        TransactionType.CREDIT,   Currency.AZN,  3_200, "AZ", now.minusDays(3)),
                new Transaction("TRX008", "4169 2222", "Ganja Branch",        TransactionType.TRANSFER, Currency.USD,  5_500, "US", now.minusDays(1)),

                // Ali Babayev — 4169 5551
                new Transaction("TRX009", "4169 5551", "Baku Main Branch",    TransactionType.CREDIT,   Currency.AZN, 15_000, "AZ", now.minusDays(10)),
                new Transaction("TRX010", "4169 5551", "Baku Main Branch",    TransactionType.TRANSFER, Currency.EUR, 12_000, "FR", now.minusDays(7)),
                new Transaction("TRX011", "4169 5551", "Baku Main Branch",    TransactionType.TRANSFER, Currency.USD,  9_500, "US", now.minusDays(4)),
                new Transaction("TRX012", "4169 5551", "Baku Main Branch",    TransactionType.DEBIT,    Currency.AZN,  6_700, "AZ", now.minusDays(2)),
                new Transaction("TRX013", "4169 5551", "Baku Main Branch",    TransactionType.TRANSFER, Currency.GBP, 11_000, "GB", now.minusDays(1)),

                // Rəşad Hüseynov — 4169 7771 / 7772
                new Transaction("TRX014", "4169 7771", "Sumgait Branch",      TransactionType.DEBIT,    Currency.AZN,  2_300, "AZ", now.minusDays(6)),
                new Transaction("TRX015", "4169 7772", "Sumgait Branch",      TransactionType.CREDIT,   Currency.AZN,  4_100, "AZ", now.minusDays(4)),
                new Transaction("TRX016", "4169 7771", "Sumgait Branch",      TransactionType.TRANSFER, Currency.USD,  3_800, "US", now.minusDays(2)),

                // Aynur İsmayıl — 4169 8881
                new Transaction("TRX017", "4169 8881", "Lankaran Branch",     TransactionType.CREDIT,   Currency.AZN,  7_200, "AZ", now.minusDays(8)),
                new Transaction("TRX018", "4169 8881", "Lankaran Branch",     TransactionType.DEBIT,    Currency.AZN,  1_900, "AZ", now.minusDays(3)),
                new Transaction("TRX019", "4169 8881", "Lankaran Branch",     TransactionType.TRANSFER, Currency.EUR,  5_600, "IT", now.minusDays(1)),

                // Günel Rzayeva — 4169 0001 / 0002
                new Transaction("TRX020", "4169 0001", "Baku Main Branch",    TransactionType.DEBIT,    Currency.AZN,    450, "AZ", now.minusDays(9)),
                new Transaction("TRX021", "4169 0002", "Baku Main Branch",    TransactionType.CREDIT,   Currency.AZN,  6_300, "AZ", now.minusDays(5)),
                new Transaction("TRX022", "4169 0002", "Baku Main Branch",    TransactionType.TRANSFER, Currency.USD,  4_200, "US", now.minusDays(2)),

                // ⚠ Fraud scenario — 4169 4441 — 4 transactions within 1 hour
                new Transaction("TRX023", "4169 4441", "Baku Main Branch",    TransactionType.DEBIT,    Currency.AZN,    200, "AZ", now.minusMinutes(55)),
                new Transaction("TRX024", "4169 4441", "Baku Main Branch",    TransactionType.DEBIT,    Currency.AZN,    150, "AZ", now.minusMinutes(40)),
                new Transaction("TRX025", "4169 4441", "Sumgait Branch",      TransactionType.DEBIT,    Currency.AZN,    300, "AZ", now.minusMinutes(25)),
                new Transaction("TRX026", "4169 4441", "Ganja Branch",        TransactionType.DEBIT,    Currency.AZN,    180, "AZ", now.minusMinutes(10))
        );
    }

    // ─────────────────────────────────────────────────────────────
    //  OLD / NEW SYSTEM IBANs  (for S15)
    // ─────────────────────────────────────────────────────────────
    public static List<String> oldSystemIbans() {
        return List.of(
                "AZ21NABZ00000000137010001944",
                "AZ96NABZ00000000137010001945",
                "AZ04NABZ00000000137010001946",
                "AZ77NABZ00000000137010001947",
                "AZ33NABZ00000000137010001948"
        );
    }

    public static List<String> newSystemIbans() {
        return List.of(
                "AZ21NABZ00000000137010001944",
                "AZ96NABZ00000000137010001945",
                "AZ55NABZ00000000137010001999",  // newly added
                "AZ77NABZ00000000137010001947"
                // 1946 and 1948 are missing in new system!
        );
    }
}