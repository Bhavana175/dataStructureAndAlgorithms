package mylearning.com.interviewMorganStanley;

public class Solution {


    /*

    Inheritance

    multi level classes , one object creation is allowed
    B extends A
    C extends B
    one instance of A, B, C


   immutable
   custom impl --> Test two var --> list Of String , Custom Object Employee emp{name, id}
   String str = "Test";  ---> assign
   String str1 = new String("Test") --> object will be created heap

     */

}

class A{

    static A instanceOfA;
    boolean flagForA = true;

     A(){
         if(flagForA && instanceOfA!= null){
             throw new IllegalArgumentException();
         }
    }
    A(boolean flagForA){
         this.flagForA = flagForA;
    }

    public static A getInstance(){

        if(instanceOfA == null){
            return  new A();
        }
        return instanceOfA;
    }
}

class B extends A{
    static B instanceOfB;

    B(){
        super(false);
       if(instanceOfB!= null){
          throw new IllegalArgumentException();
       }


    }
    public static B getInstance(){

        if(instanceOfB == null){
            return  new B();
        }
        return instanceOfB;
    }
}

class C extends B{


}
