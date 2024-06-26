package com.workspace.learning.interviews.epampractice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Person {

    private String firstName;
    private String lastName;
    private Integer salary ;

    public Person(String firstName, String lastName, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }


}
class Main{

    public static void main(String[] args) {

        Person p1 = new Person("zavana", "Karde", 8000);
        Person p2 = new Person("Sneha", "Karde", 20000);
        Person p3 = new Person("Khushi", "Karde", 5500);
        Person p4 = new Person("Shreya", "Karde", 1500);
        Person p5 = new Person("Rekha", "Karde", 80000);

        List<Person> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        //salary >5000, sort by name
        List<Person> personList = list.stream()
                .filter((p) -> p.getSalary() > 5000)
                .sorted((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()))
                .toList();

        System.out.println(personList);

    }

}
