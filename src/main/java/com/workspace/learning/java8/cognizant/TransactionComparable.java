package com.workspace.learning.java8.cognizant;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

//import static org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder.map2;

// revenue = price * quantity
// get list of transaction sorted order from high to low revenue;
@Data
@AllArgsConstructor
public class TransactionComparable implements Comparable {

    int id;

    String product;

    double price;

    int quantity;

    @Override
    public int compareTo(Object o) {
        TransactionComparable t = (TransactionComparable) o;

        if (this.getPrice() * this.getQuantity() < t.getPrice() * t.getQuantity()) {
            return 1;
        }
        if (this.getPrice() * this.getQuantity() > t.getPrice() * t.getQuantity()) {
            return -1;
        }
        return 0;
    }
}

class MainClient {

    public static void main(String[] args) {

        TransactionComparable t1 = new TransactionComparable(1, "Pen", 20.0, 100);
        TransactionComparable t2 = new TransactionComparable(1, "Pencil", 20.0, 80);
        TransactionComparable t3 = new TransactionComparable(1, "Sheet", 20.0, 90);
        TransactionComparable t4 = new TransactionComparable(1, "Book", 20.0, 180);
        TransactionComparable t5 = new TransactionComparable(1, "Red pen", 20.0, 150);

        List<TransactionComparable> transactionList = new ArrayList<>();

        transactionList.add(t1);
        transactionList.add(t2);
        transactionList.add(t3);
        transactionList.add(t4);
        transactionList.add(t5);

        Collections.sort(transactionList);
        System.out.println("list ");
        System.out.println(transactionList);

       // Collections.sort(transactionList, (a, b) -> b.getQuantity() - a.getQuantity());
        System.out.println();
        //revenue = price * quantity
        System.out.println("tree ");
        Map<Double, List<TransactionComparable>> collect = transactionList.stream()
                .collect(Collectors.groupingBy((t) -> t.getQuantity() * t.getPrice()));
        TreeMap tree = new TreeMap(collect);

        tree.entrySet().stream().forEach(System.out::println);
    }

}
