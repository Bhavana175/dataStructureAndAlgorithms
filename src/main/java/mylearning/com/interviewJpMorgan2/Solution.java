package mylearning.com.interviewJpMorgan2;

import java.util.HashSet;

public class Solution {

//JP Morgan
    /*
    Employee obj
    name
    id,
    dateOfBirth

    hashset, no duplicate combination

     */

    public static void main(String[] args) {

        Employee e1 = new Employee(1,"Ram","22/10/2000");
        Employee e2 = new Employee(2,"Syam","22/10/2000");
        Employee e3 = new Employee(3,"Sita","22/10/2000");
        Employee e4 = new Employee(1,"Rohan","22/10/2000");
        Employee e5 = new Employee(1,"Ram","22/10/2000");

        HashSet<Employee> set = new HashSet<>();

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        System.out.println(set);
        System.out.println(set.size());


        /*

        Parents table
        select query primary key
        few records
        slow query

       line --> reverse the words
       --->input : India is my country
           output : country my is India
        stack
         */


    }


}
