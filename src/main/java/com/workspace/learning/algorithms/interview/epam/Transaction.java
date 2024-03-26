package com.workspace.learning.algorithms.interview.epam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// revenue = price * quantity
// get list of transaction sorted order from high to low revenue;
public class Transaction {

    int id;
    String name;

    int quantity;
    double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public Transaction(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public static void main(String[] args) {

        Transaction t1 = new Transaction(12, "pen", 90, 10 );
        Transaction t2 = new Transaction(12, "pencil", 10, 20 );
        Transaction t3 = new Transaction(12, "noteBook", 10, 40 );

        List<Transaction> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);

        // revenue = price * quantity
        // get list of transaction sorted order from high to low on the basis of revenue;

        // Sort transactions based on revenue (price * quantity) in descending order
        Map<Double, List<Transaction>> val = list.stream()
                .sorted(Comparator.comparingDouble(transaction -> -transaction.getPrice() * transaction.getQuantity()))
                .collect(Collectors.groupingBy(transaction -> transaction.getPrice() * transaction.getQuantity()));

        List<Transaction> sortedTransactions = list.stream()
                .sorted(Comparator.comparingDouble(transaction -> -transaction.getPrice() * transaction.getQuantity()))
                .collect(Collectors.toList());

        val.entrySet().forEach(System.out::println);

        System.out.println();
        sortedTransactions.forEach(System.out::println);


    }
}
