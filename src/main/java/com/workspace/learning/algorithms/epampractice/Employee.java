package com.workspace.learning.algorithms.epampractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static void main(String[] args) {

        Employee e1 = new Employee(123, "Mahesh", "Pune");
        Employee e2 = new Employee(12, "Bhavana", "Pune");
        Employee e3 = new Employee(127, "Animesh", "Pune");
        Employee e4 = new Employee(129, "Sneh", "Pune");
        Employee e5 = new Employee(103, "Khushi", "Pune");

        //print employee sorted via name in reverse alphabetical order

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .forEach(System.out::println);

        Optional.of(e1)
                .ifPresentOrElse(employee -> employee.print(employee),
                        ()-> {throw new RuntimeException();});

    }

    public void print(Employee e){
        System.out.println("e");

    }

}
