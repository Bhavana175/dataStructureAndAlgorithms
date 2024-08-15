package mylearning.com.java8;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

//https://blog.devgenius.io/java-8-real-time-coding-interview-questions-and-answers-fce01f3c4080
public class EmployeeMain {

    private static List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();

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

        return employeeList;
    }


    public static void main(String[] args) {

        List<Employee> employeeList = getEmployeeList();

        Employee employee = new Employee();

        //Find out the count of male and female employees present in the organization?

        long femaleEmployeeCount  = employeeList.stream().filter(emp -> emp.getGender().equalsIgnoreCase("female")).count();
        long maleEmployeeCount  = employeeList.stream().filter(emp -> emp.getGender().equalsIgnoreCase("male")).count();
        System.out.println(femaleEmployeeCount);
        System.out.println(maleEmployeeCount);

        Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        Map<String, Long> noOfMaleAndFemaleEmployees1 = employeeList.stream()
                .collect(Collectors.groupingBy(e->e.getGender(), Collectors.counting()));

        System.out.println(noOfMaleAndFemaleEmployees);
        System.out.println(noOfMaleAndFemaleEmployees1);

        //Write a program to print the names of all departments in the organization.

        employeeList.stream().map(emp->emp.getDepartment()).distinct().forEach(System.out::println);

        //Find the average age of Male and Female Employees.
      employeeList.stream()
                .filter(emp -> emp.getGender().equalsIgnoreCase("female"))
                .map(femaleEmp -> femaleEmp.getAge())
                .mapToDouble(age -> age.doubleValue())
                .average().ifPresentOrElse(System.out::println, ()-> System.out.println("notfound"));


        employeeList.stream()
                .filter(emp -> emp.getGender().equalsIgnoreCase("male"))
                .map(Employee::getAge)
                .mapToDouble(Integer::doubleValue)
                .average().ifPresentOrElse(System.out::println, ()-> System.out.println("notfound"));

        Map<String, Double> ageAvg = employeeList.stream().collect(Collectors.groupingBy
                        (emp -> emp.getGender(), Collectors.averagingInt(emp -> emp.getAge())));

        System.out.println(ageAvg);

        //Get the Names of employees who joined after 2015.


        employeeList.stream()
                .filter(emp->emp.yearOfJoining>2015)
                .map(emp->emp.name)
                .forEach(System.out::println);


        //Count the number of employees in each department.

        Map<String, Long> numberOfEmpInEachDept = employeeList.stream().collect
                (Collectors.groupingBy
                (emp -> emp.getDepartment(), Collectors.counting()));

        System.out.println(numberOfEmpInEachDept);

        //Find out the average salary of each department.

        Map<String, Double> avgSalaryOfEmpInEachDept = employeeList.stream().collect
                (Collectors.groupingBy
                        (emp -> emp.getDepartment(), Collectors.averagingDouble(emp->emp.getSalary())));

        System.out.println(avgSalaryOfEmpInEachDept);

        //. Find out the oldest employee, his/her age and department?

        employeeList.stream().sorted((a,b)-> b.getAge()-a.getAge())
                .findFirst().ifPresentOrElse(System.out::println, ()-> System.out.println("not found"));

        //Find out the average and total salary of the organization.

        employeeList.stream().map(emp -> emp.getSalary())
                .mapToDouble(sal -> sal.doubleValue())
                .average()
                .ifPresentOrElse(System.out::println,()-> System.out.println("notfound"));

        double sum = employeeList.stream().map(emp -> emp.getSalary())
                .mapToDouble(sal -> sal.doubleValue())
                .sum();

        System.out.println(sum);

    }





}
