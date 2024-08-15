package mylearning.com.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable {

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                '}';
    }

    int rollNumber;
    String name;

    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        List<Integer> list2 = new ArrayList<>();

        list2.add(20);
        list2.add(30);
        list2.add(10);
        list2.add(50);
        list2.add(5);

        List<Student> list = new ArrayList<>();

        Student stud1 = new Student(1, "Aman");
        Student stud2 = new Student(50, "Sneh");
        Student stud3 = new Student(20, "Neha");
        Student stud4 = new Student(30, "Poonam");
        list.add(stud1);
        list.add(stud2);
        list.add(stud3);
        list.add(stud4);

        Comparator<Student> comp = (o1,o2)-> o1.rollNumber-o2.rollNumber;
        // Comparator<Student> comp2 = Comparator.comparingInt(o -> o.rollNumber);


        Collections.sort(list);
        for (Student element: list
             ) {
            System.out.println(element);
        }


    }

    @Override
    public int compareTo(Object o) {
        Student s2 = (Student) o;
        return s2.getName().compareTo(this.getName());
    }
}
