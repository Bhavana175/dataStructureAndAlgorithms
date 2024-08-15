package mylearning.com.designpatterns;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Employee {


    private int id;

    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static EmployeeBuilder builder(){
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder{
        private int id;
        private String name;
        public EmployeeBuilder id(int id) {
            this.id = id;
            return this;
        }
        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }
        public Employee build(){
            return new Employee(this.id, this.name);
        }
    }


}
