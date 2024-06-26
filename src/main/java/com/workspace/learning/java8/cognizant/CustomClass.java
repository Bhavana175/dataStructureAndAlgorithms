package com.workspace.learning.java8.cognizant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomClass {

    public static void main(String[] args) {

        System.out.println("print note book in descending order based on quantity");

        NoteBook n1 = new NoteBook(1, "java", 30);
        NoteBook n2 = new NoteBook(1, "c", 40);
        NoteBook n3 = new NoteBook(1, "c++", 102);
        NoteBook n4 = new NoteBook(1, "micro", 75);
        NoteBook n5 = new NoteBook(1, "sys", 66);
        NoteBook n6 = new NoteBook(1, "lld", 2);

        List<NoteBook> noteBookList = new ArrayList<>();
        noteBookList.add(n1);
        noteBookList.add(n2);
        noteBookList.add(n3);
        noteBookList.add(n4);
        noteBookList.add(n5);
        noteBookList.add(n6);

        noteBookList.stream()
                .sorted((nb1, nb2) -> nb2.getQuantity() - nb1.getQuantity())
                .forEach(System.out::println);

        System.out.println("group by book name");

        Map<String, List<NoteBook>> stringListMap = noteBookList.stream()
                .collect(Collectors.groupingBy((book) -> book.bookName));

        stringListMap.entrySet().stream().forEach(System.out::println);

    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class NoteBook {

    int id;

    String bookName;

    int quantity;

}
