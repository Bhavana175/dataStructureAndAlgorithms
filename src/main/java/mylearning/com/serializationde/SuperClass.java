package mylearning.com.serializationde;

import java.io.Serializable;

public class SuperClass implements Serializable {

    public static int x=0;
    public int y=10;
    public String str = "SuperClassTransient";

public void m1(){
    System.out.println("superclass");
}
}
