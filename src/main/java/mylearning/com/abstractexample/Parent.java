package mylearning.com.abstractexample;

public abstract class Parent {
    protected int num = 10;

    Parent(){
        System.out.println("Parent class default constructor.");
    }

    Parent(String x){
        System.out.println("Parent class parameterised constructor.");
    }

    public  static void foo(int n){
        System.out.println("Parent class foo!"+n);
    }
    public   void fooException(int n) throws RuntimeException{
        System.out.println("Parent class foo!"+n);
    }

    public  abstract  void fooabstractMethod(int n);

}
