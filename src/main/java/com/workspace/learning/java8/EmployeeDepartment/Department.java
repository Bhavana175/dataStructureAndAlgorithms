package com.workspace.learning.java8.EmployeeDepartment;

import com.workspace.learning.java8.EmployeeDepartment.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    int id ;
    String name;
    List<Employee> employeeList;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

    public List<Department> getDepartmentList(){
        Employee emp = new Employee();

        Department d1= new Department(101, "HR", emp.getEmployeeList());
        Department d2= new Department(101, "Admin", emp.getEmployeeList());
        Department d3= new Department(101, "Manager", emp.getEmployeeList());
        Department d4= new Department(101, "IT", emp.getEmployeeList());

        return Arrays.asList(d1,d2,d3,d4);

    }
}

class MainDep{

    public static void main(String[] args) {


        Department dep = new Department();

        List<Department> departmentList = dep.getDepartmentList();
        //find all employees from HR department with top 2 salary

        departmentList.stream()
                .filter(d -> d.getName().equals("HR"))
                .flatMap(hr -> hr.employeeList.stream())
                .sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary()))
                .limit(2)
                .forEach(System.out::println);
        System.out.println();
        //name starts with s in IT dep
        departmentList.stream()
                .filter(s->s.getName().equals("IT"))
                .flatMap(it->it.getEmployeeList().stream())
                .filter(em->em.getName().toLowerCase().startsWith("s"))
                .forEach(System.out::println);

    }

}
