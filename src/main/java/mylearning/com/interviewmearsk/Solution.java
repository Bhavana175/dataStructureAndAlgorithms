package mylearning.com.interviewmearsk;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
mearsk
 */
public class Solution {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        //filter all employees where department is "HR"

        employeeList.stream().filter((emp)->emp.getDepartment().equalsIgnoreCase("HR"))
                .forEach((e)-> System.out.println(e));
        // how many employees are female and male

        long femaleEmpCount = employeeList.stream().filter((e1) -> e1.getGender().equalsIgnoreCase("Female")).count();
        long maleEmpCount = employeeList.stream().filter((e1) -> e1.getGender().equalsIgnoreCase("male")).count();

        System.out.println(femaleEmpCount);
        System.out.println(maleEmpCount);

        Map<String, Long> map = employeeList.stream().collect(Collectors.groupingBy((e2) -> e2.getGender(), Collectors.counting()));
        map.forEach((k,v)-> System.out.println(k+" "+ v));

        //10,000/req    records to insert/update wearhouse
        // update
        // insert
        // --> queue --> multiple consumer ack

        /*
        employees DB
        check how which dep has highest no. of empl

            select count(emp_id) , dep from employee



            hr = 3 , finance =3, tech =2,  admin 1


         */


    }




}

@Data
 class Employee{

     int id;
     String name;
     int age;
     String gender;
     String department;
     int yearOfJoining;
     double salary;
     public Employee(int id, String name, int age, String gender, String department,
                     int yearOfJoining, double salary)
     {
         this.id = id;
         this.name = name;
         this.age = age;
         this.gender = gender;
         this.department = department;
         this.yearOfJoining = yearOfJoining;
         this.salary = salary;
     }


 }
