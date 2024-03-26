package com.workspace.learning.algorithms.interview.epam;

import lombok.Data;

import java.util.List;

@Data
public class Department {

    int id;
    String depName;

    List<Employee> employeeList;

}
@Data
class Employee{

    int empId;
    String name;
    Double salary;

    public Employee(int empId, String name, Double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
class Main{

        public static void main(String[] args) {

            // print salary for one department (111,400,600)

        }


    }

}
