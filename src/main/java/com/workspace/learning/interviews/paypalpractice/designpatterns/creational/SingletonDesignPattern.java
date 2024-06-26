package com.workspace.learning.interviews.paypalpractice.designpatterns.creational;

public class SingletonDesignPattern {
    /*
    The primary purpose of a java Singleton class is to restrict
    the limit of the number of object creations to only one.
    This often ensures that there is access control to resources,
    for example, socket or database connection.

    Memory space wastage does not occur with the use of the singleton class
    because it restricts instance creation

    1. Ensure that only one instance of the class exists.

    2. Provide global access to that instance by

    Declaring all constructors of the class to be private.
    Providing a static method that returns a reference to the instance.
    The lazy initialization concept is used to write the static methods.
    The instance is stored as a private static variable.
     */

}

class SingletonImpl {

    private static SingletonImpl singletonImpl ;
    public static String s;

    private SingletonImpl(){
        s="Singleton class variable ";
    }

    public static SingletonImpl getInstance(){

        if(singletonImpl==null){
            singletonImpl = new SingletonImpl();
        }
        return singletonImpl;
    }

}
class Main{

    public static void main(String[] args) {

        SingletonImpl x = SingletonImpl.getInstance();
        SingletonImpl y = SingletonImpl.getInstance();
        SingletonImpl z = SingletonImpl.getInstance();

        System.out.println(x.hashCode());
        System.out.println(y.hashCode());
        System.out.println(z.hashCode());
        System.out.println(x.s);
        System.out.println(y.s);
        System.out.println(z.s);
        x.s =x.s.toUpperCase();

        System.out.println(x.s);
        System.out.println(y.s);
        System.out.println(z.s);
    }

}
