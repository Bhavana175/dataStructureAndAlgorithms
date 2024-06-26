package com.workspace.learning.java8.cognizant;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
public class Employee {

    int empId;

    String name;

    Double salary;

}

@Data
@AllArgsConstructor
class Department {

    int depId;

    String depName;

    List<Employee> empList = new ArrayList<>();

}

class Main {

    //find all employees from HR department with top 2 salary
    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Ram", 200000.0);
        Employee e2 = new Employee(1, "Sam", 600000.0);
        Employee e3 = new Employee(1, "Rock", 900000.0);
        Employee e4 = new Employee(1, "Hima", 1000000.0);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);

        Department d1 = new Department(1, "HR", employeeList);
        Department d2 = new Department(1, "IT", employeeList);
        Department d3 = new Department(1, "Network", employeeList);

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(d1);
        departmentList.add(d2);
        departmentList.add(d3);

        departmentList.stream()
                .filter(dep -> dep.getDepName().equalsIgnoreCase("HR"))
                .flatMap(hr -> hr.getEmpList().stream())
                .sorted((emp1, emp2) ->
                        {
                            if (emp2.getSalary() > emp1.getSalary()) {
                                return 1;
                            }
                            if (emp2.getSalary() < emp1.getSalary()) {
                                return -1;
                            }
                            return 0;
                        }
                ).limit(2).forEach(System.out::println);



        departmentList.stream().filter((o)->o.getDepName().equalsIgnoreCase("IT"))
                .flatMap((it)->it.getEmpList().stream())
                .filter((itemp)->itemp.getName().toLowerCase().startsWith("r"))
                .forEach(System.out::println);
        //name starts with r
    }

}
