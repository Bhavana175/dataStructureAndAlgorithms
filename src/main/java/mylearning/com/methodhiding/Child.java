package mylearning.com.methodhiding;

public class Child extends Parent{

    public void myNonStaticMethod(){
        System.out.println("child method");

    }

    public void myNonStaticMethod(String str){
        System.out.println("child method");

    }

//method hiding
    public static void myStaticMethod(){
        System.out.println("child static method");

    }

}
