package mylearning.com.methodhiding;

public class Main {

    public static void main(String[] args) {
        Parent obj = new Child();

       //run time polymorphism
        obj.myNonStaticMethod();

        //method hiding
        obj.myStaticMethod();

        //normal call
        Parent obj2 = new Parent();
        obj2.myStaticMethod();

        Child obj3 = new Child();
        obj3.myStaticMethod();
        obj3.myNonStaticMethod();
        obj3.myNonStaticMethod("abc");

    }

}
