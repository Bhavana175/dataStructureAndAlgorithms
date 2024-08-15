package mylearning.com.interview3;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {

    private double salary;

    private String dep;

    private String name;

    public Employee(double salary, String dep, String name) {
        this.salary = salary;
        this.dep = dep;
        this.name = name;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", dep='" + dep + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public String getDep() {
        return dep;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        Employee emp1 = new Employee(20000, "engineering", "bhavana");
        Employee emp2 = new Employee(10000, "engineering", "sneh");
        Employee emp3 = new Employee(40000, "engineering", "shreya");
        Employee emp4 = new Employee(50000, "engineering", "shubham");
        Employee emp5 = new Employee(80001, "engineering", "rekha");
        Employee emp6 = new Employee(90000, "engineering", "aditya");

        List<Employee> list = Arrays.asList(emp5, emp1, emp2, emp3, emp4, emp6);

        list.stream()
                .filter(emp -> emp.dep.equals("engineering"))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        // add list into map using stream

        Map<String, Double> hashMap = new HashMap<>();
        list.stream().forEach(employee -> hashMap.put(employee.name, employee.salary));
        for (Map.Entry element : hashMap.entrySet()
        ) {
            System.out.println(element.getKey() + " " + element.getValue());
        }
    }

}
