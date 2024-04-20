package com.workspace.learning.java8.EmployeeDepartment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    int id;
    String name;

    Double salary;


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
    public  List<Employee> getEmployeeList() {
        Employee e1 = new Employee(1, "Bhavana", 100000.0);
        Employee e2 = new Employee(2, "Sneh", 12200.0);
        Employee e3 = new Employee(5, "Aman", 100.0);
        Employee e4 = new Employee(7, "RAm", 1000.0);
        Employee e5 = new Employee(8, "Siya", 900000.0);
        Employee e6 = new Employee(10, "Khushi", 10.0);

        return Arrays.asList(e1, e2, e3, e4, e5, e6);
    }
}

class Main {

    public static void main(String[] args) {

        Employee emp = new Employee();
        List<Employee> employeeList = emp.getEmployeeList();

        //first top 3 highest salary
        employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        employeeList.stream()
                .sorted((emp1, emp2) -> emp2.getSalary().compareTo(emp1.getSalary()))
                .limit(3)
                .forEach(System.out::println);

        System.out.println();

        employeeList.stream().sorted((emp1, emp2) -> emp1.getName().compareTo(emp2.getName()))
                .forEach(System.out::println);

        System.out.println("sort on basis of id");

        employeeList.stream().sorted((emp1, emp2) -> emp1.getId()- emp2.getId())
                .forEach(System.out::println);

    }



}
