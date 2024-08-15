package mylearning.com.methodhiding;

import java.sql.SQLOutput;

public class Parent {



    public void myNonStaticMethod(){
        System.out.println("parent method");

    }

    public static void myStaticMethod(){
        System.out.println("parent static method");

    }
}
