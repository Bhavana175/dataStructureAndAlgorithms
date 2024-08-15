package mylearning.com.serializationde;

public class SubClass extends SuperClass {
    public static int i=0;
    public int j=10;
    transient String str = "transient";

public void m1(){
    System.out.println("subClass");
}
}
