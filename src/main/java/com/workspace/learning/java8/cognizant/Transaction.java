package com.workspace.learning.java8.cognizant;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder.map2;

// revenue = price * quantity
// get list of transaction sorted order from high to low revenue;
@Data
@AllArgsConstructor
public class Transaction {

    int id;

    String product;

    double price;

    int quantity;

    public static void main(String[] args) {

        Transaction t1 = new Transaction(1, "Pen", 20.0, 100);
        Transaction t2 = new Transaction(1, "Pencil", 20.0, 80);
        Transaction t3 = new Transaction(1, "Sheet", 20.0, 90);
        Transaction t4 = new Transaction(1, "Book", 20.0, 180);
        Transaction t5 = new Transaction(1, "Red pen", 20.0, 150);

        List<Transaction> transactionList = new ArrayList<>();

        transactionList.add(t1);
        transactionList.add(t2);
        transactionList.add(t3);
        transactionList.add(t4);
        transactionList.add(t5);
        //revenue = price * quantity

        Map<Double, List<Transaction>> map = transactionList.stream()
                .collect(Collectors.groupingBy((a) -> a.getPrice() * a.getQuantity()));

        map.entrySet().stream().sorted((e1, e2) -> {
            if (e2.getKey() > e1.getKey()) {
                return 1;
            }
            if (e2.getKey() < e1.getKey()) {
                return -1;
            }
            return 0;
        }).forEach(System.out::println);

        System.out.println("2");
        Stream<Map.Entry<Double, List<Transaction>>> sorted =
                map.entrySet().stream().sorted(Comparator.comparingDouble(a -> -a.getKey()));
        sorted.forEach(System.out::println);
    }
//    1.003, 1.007

}
