package org.example.stream.task;

import org.example.stream.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class part1 {
    public static void main(String[] args) {
     List<Customer> customers = TestData.customers();
     //S1. Müştəri siyahısından yalnız aktiv olanları (status == ACTIVE) götür və adlarını əlifba sırası ilə qaytar.
     List<String>customerNameList=customers.stream()
             .filter(x->Status.ACTIVE.equals(x.status()))
             .map(Customer::name)
             .sorted()
             .toList();
        System.err.println(customerNameList);

     // S2. Son 30 günün tranzaksiyalarından ümumi məbləği hesabla.
        List<Transaction> transactionList=TestData.transactions();
        Double sumTransaction=transactionList.stream()
                .filter(x->x.date().isAfter(LocalDateTime.now().minusDays(30)))
                .mapToDouble(Transaction::amount)
                .sum();
        System.err.println(sumTransaction);

     //S3. Kartların siyahısından limit 5000-dən yuxarı olanların sayını tap.

     Long count=customers.stream()
             .flatMap(x->x.cards().stream()
             .filter(y->y.limit()>5000)).count();
     System.out.println("5000-dən yuxarı limitli kart sayı: " + count);

    //S4. Tranzaksiya siyahısından ən böyük 3 ödənişi tap.
    List<Transaction> t2 =transactionList.stream().
    sorted(Comparator.comparingDouble(Transaction::amount).reversed()).limit(3).toList();

   //S5. İstifadəçilərin IBAN siyahısından dublikatları aşkarla.
        List<String> oldSystemIbans = TestData.oldSystemIbans();
        List<String> newSystemIbans = TestData.newSystemIbans();
        List<String> dublicateIbans = oldSystemIbans.stream()
                .filter(newSystemIbans::contains)
                .toList();
        System.out.println("dublicate ibans: " + dublicateIbans);

    //S6. Tranzaksiyaları tipə görə qruplaşdır (CREDIT, DEBIT, TRANSFER) və hər tip üzrə ümumi məbləği hesabla.

        Map<TransactionType,Double> transactionGroup = transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::type, Collectors.summingDouble(Transaction::amount)));
        System.err.println(transactionGroup);
        //"Nəticəni məbləğə görə sıralı qaytara bilərsənmi?"
        transactionGroup.entrySet().stream()
                .sorted(Map.Entry.<TransactionType, Double>comparingByValue().reversed())
                .forEach(e -> System.out.printf("%s → %.2f%n", e.getKey(), e.getValue()));

    //S7. Müştəriləri şəhərə görə qruplaşdır, hər şəhərdə ortalama balansı hesabla, yalnız ortalama balansı 10,000-dən yuxarı olanları qaytar.

        Map<String, Double> c3 = customers.stream()
                .collect(Collectors.groupingBy(Customer::city, Collectors.averagingDouble(Customer::balance)))
                .entrySet().stream()
                .filter(x -> x.getValue() > 10000)
                .collect(Collectors.toMap
                        (Map.Entry::getKey,
                         Map.Entry::getValue));
        System.out.println(c3);

    //S8. Aşağıdakı record-lardan istifadə edərək hər filialın aylıq dövriyyəsini hesabla.
        Map<String, Map<Month, Double>> t8 = transactionList.stream()
                .collect(Collectors.groupingBy(
                                Transaction::branch,
                                Collectors.groupingBy(
                                        t ->t.date().getMonth(),
                        Collectors.summingDouble(Transaction::amount)
                )
        ));
        System.out.println(t8);

    //S9. Müştərilərin kart siyahıları iç-içədir — bütün aktiv kartları bir siyahıya yığ.
        List<Card> activeCardList =customers.stream()
                .flatMap(x->x.cards().stream()
                .filter(Card::active)).toList();
        System.out.println(activeCardList);

    //S10. Ödənişləri valyutaya görə qruplaşdır, hər valyuta üzrə ən böyük ödənişi tap.

  Map<Currency, Double> t10 = transactionList.stream()
          .collect(Collectors.groupingBy(Transaction::currency,Collectors.collectingAndThen(
                  Collectors.maxBy(Comparator.comparing(Transaction::amount)),
          opt->opt.map(Transaction::amount).orElse(0.0))));
    }
}
