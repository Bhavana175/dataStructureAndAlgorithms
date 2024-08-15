package mylearning.com.interviewJpMorgan2;

import lombok.Data;

import java.util.Objects;

@Data
public class Employee {

    int id;
    String name;
    String dob;

    public Employee(int id, String name, String dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return getId() == employee.getId() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
