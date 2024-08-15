package mylearning.com.overridding;

public class ParentSuperClass {
    protected int num = 10;

    ParentSuperClass(){
        System.out.println("Parent class default constructor.");
    }

    ParentSuperClass(String x){
        System.out.println("Parent class parameterised constructor.");
    }

    public  static void foo(int n){
        System.out.println("Parent class foo!"+n);
    }
    public  void fooException(int n) throws RuntimeException{
        System.out.println("Parent class foo!"+n);
    }

// inner class can be static
    public static class ParentSuperClassStatic extends ParentSuperClass {


    }

}
