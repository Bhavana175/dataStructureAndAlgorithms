package com.workspace.learning.algorithms.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    int id;
    String name;
    String city;

    public Employee(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Employee e1= new Employee(1,"Bhavana","Blr");
        Employee e2= new Employee(2,"Zakhir","Blr");
        Employee e3= new Employee(3,"Sneh","Blr");
        Employee e4= new Employee(4,"Ankur","Blr");
        Employee e5= new Employee(5,"Khushi","Blr");

        List<Employee> employeeList =  new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);


        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .forEach(System.out::println);

        HashSet<Character> set = new HashSet();

        String str ="asdfaghjklkjhgfdsa";
        char ch = str.chars()
                .mapToObj(c-> (char) c)
                .filter(c->!set.add(c))
                .findFirst()
                .orElse('0');

        System.out.println(ch);

    }
}
